package com.system.cafe.service.cafe;

import com.system.cafe.domain.cafe.Cafe;
import com.system.cafe.repository.cafe.CafeCustomRepository;
import com.system.cafe.repository.cafe.CafeRepository;
import com.system.cafe.domain.category.Category;
import com.system.cafe.repository.category.CategoryRepository;
import com.system.cafe.domain.hashtag.Hashtag;
import com.system.cafe.repository.hasgtag.HashtagCustomRepository;
import com.system.cafe.dto.cafe.CafeMainListResponseDto;
import com.system.cafe.dto.cafe.CafeResponseDTO;
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
    private final CafeRepository cafeRepository;
    private final CategoryRepository categoryRepository;
    private final CafeCustomRepository cafeCustomRepository;
    private final HashtagCustomRepository hashtagCustomRepository;

    @Override
    public Map<String, Object> getMainList(String currentLocation) {
        // TODO 어떤 종류의 카테고리 내려줄지 결정 필요함
        Map<String, Object> resultMap = new LinkedHashMap<>();

        // 카테고리
        List<Category> categoryList = categoryRepository.findAll();

        // HOT 매장 추천
        List<CafeMainListResponseDto> hotCafeList = cafeCustomRepository.findAllHotCafe();

        // TODO 해시태그 가중치 줘서 어떤 해시태그 가져올지 결정해야함. 일단은 랜덤으로 추출
        Hashtag hashtag = hashtagCustomRepository.findHashtag();

        // 해시태그로 매장 추천
        List<CafeResponseDTO> hashtagCafeList = Cafe.entityToDto(cafeCustomRepository.findAllCafeByHashtag(hashtag.getName()));

        // 제일 아래 리스트 랜덤으로 보내주기
        List<Cafe> cafeList = cafeCustomRepository.findAllCafe();



        resultMap.put("categoryList", categoryList);
        resultMap.put("hotCafeList", hotCafeList);
        resultMap.put("hashtagCafeList", hashtagCafeList);
        return resultMap;
    }

}
