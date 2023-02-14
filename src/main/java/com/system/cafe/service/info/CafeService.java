package com.system.cafe.service.info;

import com.system.cafe.dto.PageRequestDTO;
import com.system.cafe.dto.PageResultDTO;
import com.system.cafe.dto.info.InfoListResponseDto;
import com.system.cafe.dto.info.RecommendInfoListDTO;

import java.util.List;
import java.util.Map;

public interface CafeService {

    PageResultDTO<InfoListResponseDto, Object[]> getInfoList(PageRequestDTO pageRequestDTO); // 목록처리

    List<RecommendInfoListDTO> findRecommendList();

    List<InfoListResponseDto> findInfoList();

    Map<String,?> getMainList(String currentLocation);
}
