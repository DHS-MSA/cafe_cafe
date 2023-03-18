package com.system.cafe.repository.cafe;

import com.system.cafe.dto.cafe.CafeListResponseDto;
import com.system.cafe.dto.common.SearchRequestDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CafeCustomRepository {
    List<CafeListResponseDto> findAllHotCafe();

    List<CafeListResponseDto> findAllCafeByHashtag();

    List<CafeListResponseDto> findAllCafe();

    Slice<CafeListResponseDto> findAllWithoutOffset(SearchRequestDto requestDto);
}
