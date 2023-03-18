package com.system.cafe.dto.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 메인페이지 검색시 사용
 */
@Getter
@Setter
public class SearchRequestDto extends PageRequestDto {
    private Long lastStoreId; // 무한 스크롤 구현 시 마지막 ID값이 필요함
    private String latitude; // 위도
    private String longitude; // 경도
    private String type; // 전체, 체인점, 개인카페
    private String category; // 전체, 공부, 분위기, 디저트 ...
    private String searchWord; // 검색어
}
