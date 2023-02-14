package com.system.cafe.domain.cafe;

import com.system.cafe.dto.info.CafeListResponseDto;
import com.system.cafe.dto.info.RecommendInfoListDTO;

import java.util.List;

public interface CafeCustomRepository {

    List<RecommendInfoListDTO> findRecommendList();

    List<CafeListResponseDto> findInfoList();
}
