package com.system.cafe.controller;

import com.system.cafe.dto.cafe.CafeListResponseDto;
import com.system.cafe.dto.cafe.CafeSaveRequestDto;
import com.system.cafe.dto.common.PageResultDto;
import com.system.cafe.dto.common.SearchRequestDto;
import com.system.cafe.service.cafe.CafeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
@Log4j2
public class CafeController {

    private final CafeService cafeService;

    /**
     * 메인 리스트 검색
     */
    @GetMapping(value = "/main-list/default", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> mainList(@ModelAttribute SearchRequestDto requestDto) {
        Map<String, Object> resultMap = cafeService.getMainList(requestDto);

        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    /**
     * 메인 리스트 무한 스크롤 & 검색 후 스크롤
     */
    @GetMapping(value = "/main-list/scroll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDto> list(@ModelAttribute SearchRequestDto requestDto) {

        Slice<CafeListResponseDto> resultList = cafeService.getCafeList(requestDto);

        PageResultDto result = new PageResultDto(resultList.getContent(), resultList.hasNext());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 내 정보의 카페 목록
     */
//    @GetMapping(value = "/my-info/{userId}/cafes")

    /**
     * 카페 등록
     */
    @PostMapping(value = {"/my-info/{userId}/{uuid}", "/my-info/{userId}"})
    public ResponseEntity<?> saveCafe(final @PathVariable String userId,
                                      final @PathVariable(required = false) String uuid,
                                      final @RequestBody(required = false) @Valid CafeSaveRequestDto requestDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            String errorMessage = list.get(0).getDefaultMessage();
            log.error("errorMessage = {}", errorMessage);
            return new ResponseEntity<>("{errorMessage : \""+errorMessage+"\"}", HttpStatus.BAD_REQUEST);
        }

        cafeService.saveCafe(requestDto);


        return new ResponseEntity<>(HttpStatus.OK);
    }

}
