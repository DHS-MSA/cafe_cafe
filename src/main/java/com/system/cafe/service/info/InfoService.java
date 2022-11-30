package com.system.cafe.service.info;

import com.system.cafe.web.dto.PageRequestDTO;
import com.system.cafe.web.dto.PageResultDTO;
import com.system.cafe.web.dto.info.InfoListResponseDto;

public interface InfoService {

    PageResultDTO<InfoListResponseDto, Object[]> getInfoList(PageRequestDTO pageRequestDTO); // 목록처리

}
