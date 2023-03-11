package com.system.cafe.repository.cafe;



import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.system.cafe.domain.cafe.Cafe;
import com.system.cafe.dto.cafe.CafeMainListResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.system.cafe.domain.cafe.QCafe.cafe;
import static com.system.cafe.domain.hashtag.QHashtag.hashtag;

/**
 * @see "https://bbuljj.github.io/querydsl/2021/05/17/jpa-querydsl-projection-list.html"
 */
@Log4j2
@Repository
public class CafeCustomRepositoryImpl implements CafeCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public CafeCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }


    /**
     * HOT 매장 추천
     * @return
     */
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


    @Override
    public List<CafeMainListResponseDto> findAllHotCafe() {
        List<Cafe> cafeList = jpaQueryFactory
                .select(cafe)
                .from(cafe)
                .limit(12)
                .fetch();

        List<CafeMainListResponseDto> cafeMainListResponseDTOList = cafeList.stream()
                .map(entity -> new CafeMainListResponseDto(entity))
                .collect(Collectors.toList());

        return cafeMainListResponseDTOList;
    }

    /**
     * 해시태그로 매장 추천
     * @return
     */
    @Override
    public List<Cafe> findAllCafeByHashtag(String hashtagName) {
        return jpaQueryFactory
                .select(cafe)
                .from(cafe)
                .leftJoin(hashtag)
                .on(cafe.uuid.eq(hashtag.cafe.uuid))
                .where(hashtag.name.eq(hashtagName))
                .fetch();
    }

    /**
     * 제일 아래 리스트 랜덤으로 보내주기
     * @return
     */
    @Override
    public List<Cafe> findAllCafe() {
        return jpaQueryFactory
                .select(cafe)
                .from(cafe)
                .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
                .limit(12)
                .fetch();

    }
}
