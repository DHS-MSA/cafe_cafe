package com.system.cafe.repository.cafe;

import com.system.cafe.dto.cafe.CafeListResponseDto;

import java.util.List;

public interface CafeCustomRepository {
    List<CafeListResponseDto> findAllHotCafe();

    List<CafeListResponseDto> findAllCafeByHashtag();

    List<CafeListResponseDto> findAllCafe();
}
