package com.system.cafe.service.cafe;

import com.system.cafe.domain.cafe.CafeCustomRepository;
import com.system.cafe.domain.category.Category;
import com.system.cafe.domain.category.CategoryRepository;
import com.system.cafe.dto.cafe.CafeMainListResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class CafeServiceImpl implements CafeService {
    private final CategoryRepository categoryRepository;
    private final CafeCustomRepository cafeCustomRepository;

    @Override
    public Map<String, Object> getMainList(String currentLocation) {
        // TODO 어떤 종류의 카테고리 내려줄지 결정 필요함
        Map<String, Object> resultMap = new LinkedHashMap<>();

        // 카테고리
        List<Category> categoryList = categoryRepository.findAll();

        // HOT 매장 추천
        List<CafeMainListResponseDTO> cafeList = cafeCustomRepository.findAllHotCafe();



        resultMap.put("categoryList", categoryList);
        resultMap.put("hotCafeList", cafeList);
        return resultMap;
    }

}
