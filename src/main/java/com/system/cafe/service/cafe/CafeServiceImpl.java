package com.system.cafe.service.cafe;

import com.system.cafe.domain.category.Category;
import com.system.cafe.dto.cafe.CafeListResponseDto;
import com.system.cafe.dto.cafe.CafeSaveRequestDto;
import com.system.cafe.dto.common.SearchRequestDto;
import com.system.cafe.repository.cafe.CafeCustomRepository;
import com.system.cafe.repository.cafe.CafeRepository;
import com.system.cafe.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class CafeServiceImpl implements CafeService {
    private final CategoryRepository categoryRepository;
    private final CafeRepository cafeRepository;

    @Override
    public Map<String, Object> getMainList(SearchRequestDto requestDto) {
        // TODO 어떤 종류의 카테고리 내려줄지 결정 필요함
        Map<String, Object> resultMap = new LinkedHashMap<>();

        // 카테고리
        List<Category> categoryList = categoryRepository.findAll();

        // HOT 매장 추천
        List<CafeListResponseDto> hotCafeList = cafeRepository.findAllHotCafe();

        // 해시태그로 매장 추천
        List<CafeListResponseDto> hashtagCafeList = cafeRepository.findAllCafeByHashtag();

        // 제일 아래 리스트 랜덤으로 보내주기
        List<CafeListResponseDto> cafeList = cafeRepository.findAllCafe();

        resultMap.put("categoryList", categoryList);
        resultMap.put("hotCafeList", hotCafeList);
        resultMap.put("hashtagCafeList", hashtagCafeList);
        resultMap.put("cafeList", cafeList);

        return resultMap;
    }

    @Override
    public Slice<CafeListResponseDto> getCafeList(SearchRequestDto requestDto) {
        Slice<CafeListResponseDto> cafeList = cafeRepository.findAllWithoutOffset(requestDto);

        return cafeList;
    }

    @Override
    public void saveCafe(CafeSaveRequestDto requestDto) {

    }
}
