package com.system.cafe.dto.cafe;

import com.system.cafe.domain.cafe.Cafe;
import lombok.*;

/**
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CafeResponseDTO {

    private String uuid;

    private String name;

    private String address;

    private Double rating;

    public CafeResponseDTO(Cafe cafe) {
        this.uuid = cafe.getUuid();
        this.name = cafe.getName();
        this.address = cafe.getAddress();
        this.rating = cafe.getRating();
    }
}
