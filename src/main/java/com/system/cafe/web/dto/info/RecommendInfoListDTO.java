package com.system.cafe.web.dto.info;

import com.system.cafe.web.dto.menu.MenuDTO;
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
