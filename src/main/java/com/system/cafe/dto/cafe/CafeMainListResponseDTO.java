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
public class CafeMainListResponseDTO {
    private Long id;

    private String name;

    private String address;

    private Double rating;

    private List<MenuDTO> menuList =  new ArrayList<>();
}
