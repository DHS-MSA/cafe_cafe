package com.system.cafe.controller;

import com.system.cafe.dto.cafe.CafeListResponseDto;
import com.system.cafe.dto.common.PageResultDto;
import com.system.cafe.dto.common.SearchRequestDto;
import com.system.cafe.service.cafe.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CafeController {

    private final CafeService cafeService;

    /**
     * 메인 리스트 검색
     */
    @GetMapping(value = "/mainList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> mainList(@ModelAttribute SearchRequestDto requestDto) {
        Map<String, Object> resultMap = cafeService.getMainList(requestDto);

        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    /**
     * 메인 리스트 무한 스크롤
     */
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDto> list(@ModelAttribute SearchRequestDto requestDto) {

        Slice<CafeListResponseDto> resultList = cafeService.getCafeList(requestDto);

        PageResultDto result = new PageResultDto(resultList.getContent(), resultList.hasNext());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
