package com.system.cafe.dto.cafe;

import com.system.cafe.dto.menu.MenuDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CafeListResponseDto {

    private Long id;

    private String name;

    private String type;

    private String address;

    private Double rating;

    private List<MenuDTO> menuDTOList =  new ArrayList<>();


    public CafeListResponseDto(Long id, String name, String type, String address, Double rating) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
        this.rating = rating;
    }
}
