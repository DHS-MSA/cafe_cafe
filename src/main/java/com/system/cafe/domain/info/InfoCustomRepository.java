package com.system.cafe.domain.info;

import com.system.cafe.dto.info.InfoListResponseDto;
import com.system.cafe.dto.info.RecommendInfoListDTO;

import java.util.List;

public interface InfoCustomRepository {

    List<RecommendInfoListDTO> findRecommendList();

    List<InfoListResponseDto> findInfoList();
}
