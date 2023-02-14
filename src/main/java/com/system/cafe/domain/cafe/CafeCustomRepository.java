package com.system.cafe.domain.cafe;

import com.system.cafe.dto.cafe.CafeMainListResponseDTO;

import java.util.List;

public interface CafeCustomRepository {
    List<CafeMainListResponseDTO> findAllHotCafe();

}
