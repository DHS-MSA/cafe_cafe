package com.system.cafe.domain.cafe;



import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.system.cafe.dto.cafe.CafeMainListResponseDTO;
import com.system.cafe.dto.menu.MenuDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.system.cafe.domain.cafe.QCafe.cafe;
import static com.system.cafe.domain.hashtag.QHashtag.hashtag;
import static com.system.cafe.domain.menu.QMenu.menu;

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



    @Override
    public List<CafeMainListResponseDTO> findAllHotCafe() {
        return jpaQueryFactory
                .from(cafe)
                .leftJoin(menu)
                .on(cafe.uuid.eq(menu.cafe.uuid))
                .transform(
                    groupBy(cafe.uuid).list(
                        Projections.fields(
                            CafeMainListResponseDTO.class,
                            cafe.uuid,
                            cafe.name,
                            cafe.address,
                            cafe.rating,
                            list(
                                Projections.fields(
                                    MenuDTO.class,
                                    menu.id,
                                    menu.name
                                ).skipNulls()
                            ).as("menuList")
                    )
                )
            );
    }

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
}
