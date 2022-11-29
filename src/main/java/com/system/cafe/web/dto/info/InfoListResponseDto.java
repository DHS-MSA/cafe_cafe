package com.system.cafe.web.dto.info;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoListResponseDto {

    private String name;

    private String address;

    private Double rating;

    private String[] menus;
}
