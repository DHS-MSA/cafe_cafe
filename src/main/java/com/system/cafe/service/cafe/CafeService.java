package com.system.cafe.service.cafe;

import com.system.cafe.dto.cafe.CafeListResponseDto;
import com.system.cafe.dto.common.SearchRequestDto;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.Map;

public interface CafeService {
    Map<String, Object> getMainList(SearchRequestDto requestDto);

    Slice<CafeListResponseDto> getCafeList(SearchRequestDto requestDto);
}
