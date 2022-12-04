package com.system.cafe.service.info;

import com.system.cafe.web.dto.PageRequestDTO;
import com.system.cafe.web.dto.PageResultDTO;
import com.system.cafe.web.dto.info.InfoListResponseDto;
import com.system.cafe.web.dto.info.RecommendInfoListDTO;

import java.util.List;

public interface InfoService {

    PageResultDTO<InfoListResponseDto, Object[]> getInfoList(PageRequestDTO pageRequestDTO); // 목록처리

    List<RecommendInfoListDTO> findRecommendList();

    List<InfoListResponseDto> findInfoList();

}
