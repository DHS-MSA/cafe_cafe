package com.system.cafe.repository.cafe;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.system.cafe.domain.cafe.Cafe;
import com.system.cafe.domain.cafe.CafeType;
import com.system.cafe.dto.cafe.CafeListResponseDto;
import com.system.cafe.dto.common.SearchRequestDto;
import com.system.cafe.dto.menu.MenuDto;
import com.system.cafe.repository.hasgtag.HashtagCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.stream.Collectors;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.system.cafe.domain.cafe.QCafe.cafe;
import static com.system.cafe.domain.cafe.QCafeCategory.cafeCategory;
import static com.system.cafe.domain.hashtag.QHashtag.hashtag;
import static com.system.cafe.domain.category.QCategory.category;
import static com.system.cafe.domain.menu.QMenu.menu;

/**
 * @see "https://bbuljj.github.io/querydsl/2021/05/17/jpa-querydsl-projection-list.html"
 */
@Log4j2
@Repository
@RequiredArgsConstructor
public class CafeCustomRepositoryImpl implements CafeCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final HashtagCustomRepository hashtagCustomRepository;

//    @Override
//    public List<CafeMainListResponseDTO> findAllHotCafe() {
//        return jpaQueryFactory
//                .from(cafe)
//                .leftJoin(menu)
//                .on(cafe.uuid.eq(menu.cafe.uuid))
//                .transform(
//                    groupBy(cafe.uuid).list(
//                        Projections.fields(
//                            CafeMainListResponseDTO.class,
//                            cafe.uuid,
//                            cafe.name,
//                            cafe.address,
//                            cafe.rating,
//                            list(
//                                Projections.fields(
//                                    MenuDTO.class,
//                                    menu.id,
//                                    menu.name
//                                ).skipNulls()
//                            ).as("menuList")
//                    )
//                )
//            );
//    }


    /**
     * HOT 매장 추천
     * @return
     */
    @Override
    public List<CafeListResponseDto> findAllHotCafe() {
        List<Cafe> cafeList = jpaQueryFactory
                .select(cafe)
                .from(cafe)
                .limit(12)
                .fetch();

        List<CafeListResponseDto> cafeListResponseDtoList = cafeList.stream()
                .map(entity -> new CafeListResponseDto(entity))
                .collect(Collectors.toList());

        return cafeListResponseDtoList;
    }

    /**
     * 해시태그로 매장 추천
     * @return
     */
    @Override
    public List<CafeListResponseDto> findAllCafeByHashtag() {
        // TODO 해시태그 가중치 줘서 어떤 해시태그 가져올지 결정해야함. 일단은 랜덤으로 추출
        String hashtagName = hashtagCustomRepository.findHashtag().getName();

        List<Cafe> cafeList =  jpaQueryFactory
                .select(cafe)
                .from(cafe)
                .leftJoin(hashtag)
                .on(cafe.uuid.eq(hashtag.cafe.uuid))
                .where(hashtag.name.eq(hashtagName))
                .fetch();

        List<CafeListResponseDto> cafeListResponseDtoList = cafeList.stream()
                .map(entity -> new CafeListResponseDto(entity))
                .collect(Collectors.toList());

        return cafeListResponseDtoList;
    }

    /**
     * 제일 아래 리스트 랜덤으로 보내주기
     *
     * @return
     */
    @Override
    public List<CafeListResponseDto> findAllCafe() {
        List<Cafe> cafeList = jpaQueryFactory
                .select(cafe)
                .from(cafe)
                .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
                .limit(12)
                .fetch();

        List<CafeListResponseDto> cafeListResponseDtoList = cafeList.stream()
                .map(entity -> new CafeListResponseDto(entity))
                .collect(Collectors.toList());

        return cafeListResponseDtoList;
    }

    /**
     * 페이지 무한 스크롤
     * @return
     */
    @Override
    public Slice<CafeListResponseDto> findAllWithoutOffset(SearchRequestDto req) {
        PageRequest pageRequest = PageRequest.of(req.getPage(), req.getSize(), Sort.by(Sort.Direction.DESC, "cafe_id"));

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        // no-offset방식 처리
        if(req.getLastStoreId() != null) {
            booleanBuilder.and(cafe.id.lt(String.valueOf(req.getLastStoreId())));
        }

        // 타입
        if(!StringUtils.isNullOrEmpty(req.getType())) {
            if(req.getType().equals(CafeType.PERSONAL)) {
                booleanBuilder.and(cafe.type.eq(CafeType.PERSONAL));
            }
            if(req.getType().equals(CafeType.FRANCHISE)) {
                booleanBuilder.and(cafe.type.eq(CafeType.FRANCHISE));
            }
        }

        // 카테고리
        if(!StringUtils.isNullOrEmpty(req.getCategory())) {
            booleanBuilder.and(category.name.eq(req.getCategory()));
        }

        // 검색어
        if(!StringUtils.isNullOrEmpty(req.getSearchWord())) {
            booleanBuilder.and(cafe.name.like("%" + req.getSearchWord() + "%"));
        }

        List<CafeListResponseDto> resultList = jpaQueryFactory
                .from(cafe)
                .leftJoin(cafe.menu, menu)
                .leftJoin(cafe.cafeCategory, cafeCategory)
                .leftJoin(cafeCategory.category, category)
                .where(booleanBuilder)
                .orderBy(cafe.id.desc())
                .transform(
                        groupBy(cafe.uuid).list(
                                Projections.fields(
                                        CafeListResponseDto.class,
                                        cafe.uuid,
                                        cafe.name,
                                        cafe.address,
                                        cafe.rating,
                                        list(
                                                Projections.fields(
                                                        MenuDto.class,
                                                        menu.id,
                                                        menu.name
                                                ).skipNulls()
                                        ).as("menuDtoList")
                                )
                        )
                );

        boolean hasNext = false;
        if(resultList.size() > pageRequest.getPageSize()) {
            hasNext = true;
            resultList.remove(pageRequest.getPageSize());
        }

        return new SliceImpl<>(resultList, pageRequest, hasNext);
    }
}