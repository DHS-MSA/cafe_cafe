package com.system.cafe.service.info;

import com.system.cafe.dto.PageRequestDTO;
import com.system.cafe.dto.PageResultDTO;
import com.system.cafe.dto.info.CafeListResponseDto;
import com.system.cafe.dto.info.RecommendInfoListDTO;

import java.util.List;
import java.util.Map;

public interface CafeService {

    PageResultDTO<CafeListResponseDto, Object[]> getInfoList(PageRequestDTO pageRequestDTO); // 목록처리

    List<RecommendInfoListDTO> findRecommendList();

    List<CafeListResponseDto> findInfoList();

    Map<String,?> getMainList(String currentLocation);
}
