package com.system.cafe.dto.common;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
@NoArgsConstructor
public class PageResultDto<DTO> { // 다양한 곳에서 사용할 수 있도록 제네릭 타입을 이용해서 DTO와 EN이라는 타입을 지정(dto, entity)
    
    // JPA를 이용하는 Repository에서는 페이지 처리 결과를 Page<Entity>타입으로 반환하게 됨
    // 따라서 서비스 계층에서 이를 처리하기 위해서 별도의 클래스를 만들어서 처리해야 함
    // Page<Entity>의 엔티티 객체들을 DTO 객체로 변환해서 자료구조로 담아줘야함

    private List<DTO> dtoList; // DTO 리스트

    private boolean hasNext; //  다음

    public PageResultDto(List<DTO> dtoList, boolean hasNext) {
        this.dtoList = dtoList;
        this.hasNext = hasNext;
    }
}
