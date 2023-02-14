package com.system.cafe.domain.cafe;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.system.cafe.domain.menu.Menu;
import com.system.cafe.dto.cafe.CafeMainListResponseDTO;
import com.system.cafe.dto.menu.MenuDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.system.cafe.domain.cafe.QCafe.cafe;
import static com.system.cafe.domain.menu.QMenu.menu;


@Log4j2
@Repository
public class CafeCustomRepositoryImpl implements CafeCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public CafeCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<CafeMainListResponseDTO> findAllHotCafe() {
        return jpaQueryFactory
                .from(cafe)
                .innerJoin(menu)
                .on(cafe.id.eq(menu.cafe.id))
                .transform(
                    groupBy(cafe.id).list(
                        Projections.fields(
                            CafeMainListResponseDTO.class,
                            cafe.id,
                            cafe.name,
                            cafe.address,
                            cafe.rating,
                            list(Projections.fields(
                                    MenuDTO.class,
                                    menu.name
                                )
                            ).as("menuDTOList")
                        )
                    )
                );
    }

    /**
     * @see "https://bbuljj.github.io/querydsl/2021/05/17/jpa-querydsl-projection-list.html"
     */
//    @Override
//    public List<RecommendInfoListDTO> findRecommendList() {
//        return jpaQueryFactory
//            .from(info)
//            .innerJoin(menu)
//            .on(info.id.eq(menu.info.id))
//            .transform(
//                groupBy(info.id).list(
//                    Projections.fields(
//                        RecommendInfoListDTO.class,
//                        info.name,
//                        info.rating,
//                        list(
//                            Projections.fields(
//                                MenuDTO.class,
//                                menu.name
//                            )
//                        ).as("menuDTOList")
//                    )
//                )
//            );
//    }
//
//    @Override
//    public List<CafeListResponseDto> findInfoList() {
//        return jpaQueryFactory
//            .from(info)
//            .leftJoin(location)
//            .on(info.id.eq(location.info.id))
//            .innerJoin(menu)
//            .on(info.id.eq(menu.info.id))
//            .transform(
//                groupBy(info.id).list(
//                    Projections.fields(
//                        CafeListResponseDto.class,
//                        info.id,
//                        info.name,
//                        info.rating,
//                        location.address,
//                        list(
//                            Projections.fields(
//                                    MenuDTO.class,
//                                    menu.name
//                            )
//                        ).as("menuDTOList")
//                    )
//                )
//            );
//    }


}
