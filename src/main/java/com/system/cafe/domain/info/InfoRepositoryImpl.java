package com.system.cafe.domain.info;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.system.cafe.domain.location.QLocation.location;
import static com.system.cafe.domain.menu.QMenu.menu;

@Log4j2
@Repository
public class InfoRepositoryImpl extends QuerydslRepositorySupport implements InfoCustomRepository {

    public InfoRepositoryImpl() {
        super(Info.class);
    }

    @Override
    public List<Tuple> recommendCafeInfoList() {
        QInfo info = QInfo.info;

        JPQLQuery<Info> jpqlQuery = from(info);
        jpqlQuery.leftJoin(location).on(info.id.eq(location.id));
        jpqlQuery.leftJoin(menu).on(menu.info.eq(info));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(info.name, info.rating, location.address, menu.name);

        List<Tuple> result = tuple.fetch();

        return result;
    }
}
