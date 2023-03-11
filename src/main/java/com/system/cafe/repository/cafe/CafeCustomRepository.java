package com.system.cafe.repository.cafe;

import com.system.cafe.domain.cafe.Cafe;
import com.system.cafe.dto.cafe.CafeMainListResponseDto;

import java.util.List;

public interface CafeCustomRepository {
    List<CafeMainListResponseDto> findAllHotCafe();

    List<Cafe> findAllCafeByHashtag(String hashtagName);

    List<Cafe> findAllCafe();
}
