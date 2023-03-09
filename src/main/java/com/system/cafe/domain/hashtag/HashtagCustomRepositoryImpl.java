package com.system.cafe.domain.hashtag;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import static com.system.cafe.domain.category.QCategory.category;
import static com.system.cafe.domain.hashtag.QHashtag.hashtag;

@Repository
public class HashtagCustomRepositoryImpl implements HashtagCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;


    public HashtagCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Hashtag findHashtag() {
        return jpaQueryFactory
                .selectFrom(hashtag)
                .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
                .limit(1)
                .fetchFirst();
    }
}
