package com.system.cafe.dto.cafe;

import com.system.cafe.domain.cafe.Cafe;
import com.system.cafe.dto.menu.MenuDto;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CafeMainListResponseDto {
    private String uuid;

    private String name;

    private String address;

    private Double rating;

    private List<MenuDto> menuList; // =  new ArrayList<>();

    public CafeMainListResponseDto(Cafe cafe) {
        this.uuid = cafe.getUuid();
        this.name = cafe.getName();
        this.address = cafe.getAddress();
        this.rating = cafe.getRating();
        this.menuList = cafe.getMenu().stream()
                .map(entity -> new MenuDto(entity))
                .collect(Collectors.toList());
    }


}
