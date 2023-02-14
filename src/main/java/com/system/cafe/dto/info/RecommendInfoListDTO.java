package com.system.cafe.dto.info;

import com.system.cafe.dto.menu.MenuDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class RecommendInfoListDTO {
    private String name;
    private double rating;
    private List<MenuDTO> menuDTOList =  new ArrayList<>();
}
