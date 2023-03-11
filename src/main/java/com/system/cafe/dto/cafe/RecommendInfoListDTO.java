package com.system.cafe.dto.cafe;

import com.system.cafe.dto.menu.MenuDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class RecommendInfoListDTO {
    private String name;
    private double rating;
    private List<MenuDto> menuDTOList =  new ArrayList<>();
}
