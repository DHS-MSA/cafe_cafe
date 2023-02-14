package com.system.cafe.service.info;

import com.system.cafe.domain.cafe.CafeCustomRepository;
import com.system.cafe.domain.cafe.CafeRepository;
import com.system.cafe.dto.PageRequestDTO;
import com.system.cafe.dto.PageResultDTO;
import com.system.cafe.dto.info.CafeListResponseDto;
import com.system.cafe.dto.info.RecommendInfoListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class InfoServiceImpl implements CafeService {

    private final CafeRepository repository;
    private final CafeCustomRepository infoCustomRepository;

    @Override
    public Map<String, ?> getMainList(String currentLocation) {


        return null;
    }

    @Override
    public PageResultDTO<CafeListResponseDto, Object[]> getInfoList(PageRequestDTO pageRequestDTO) {

//        Function<Object[] , InfoListResponseDto> fn = (en -> new InfoListResponseDto((Info)en[0], (Location)en[1]));
//
//        Page<Object[]> result = repository.getCafeInfoList(pageRequestDTO.getPageable(Sort.by("name")));
//
//
//        return new PageResultDTO<>(result, fn);
        return null;
    }

    @Override
    public List<RecommendInfoListDTO> findRecommendList() {
        return infoCustomRepository.findRecommendList();
    }

    @Override
    public List<CafeListResponseDto> findInfoList() {
        return infoCustomRepository.findInfoList();
    }
}
