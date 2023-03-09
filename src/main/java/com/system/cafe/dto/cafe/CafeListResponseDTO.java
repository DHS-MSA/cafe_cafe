package com.system.cafe.dto.cafe;

import com.system.cafe.dto.menu.MenuDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CafeListResponseDTO {

    private String uuid;

    private String name;

    private String type;

    private String address;

    private Double rating;

    private List<MenuDTO> menuDTOList; // =  new ArrayList<>();


    public CafeListResponseDTO(String uuid, String name, String type, String address, Double rating) {
        this.uuid = uuid;
        this.name = name;
        this.type = type;
        this.address = address;
        this.rating = rating;
    }
}
