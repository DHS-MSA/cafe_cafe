package com.system.cafe.dto.menu;

import com.system.cafe.domain.menu.Menu;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MenuDto {

    private Long id;
    private String name;

    public MenuDto(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
    }
}
