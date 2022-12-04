package com.system.cafe.domain.info;

import com.system.cafe.web.dto.info.RecommendInfoListDTO;

import java.util.List;

public interface InfoCustomRepository {

    List<RecommendInfoListDTO> findRecommendList();
}
