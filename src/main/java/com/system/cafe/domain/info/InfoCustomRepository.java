package com.system.cafe.domain.info;

import com.querydsl.core.Tuple;

import java.util.List;

public interface InfoCustomRepository {

    List<Tuple> recommendCafeInfoList();
}
