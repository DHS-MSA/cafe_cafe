package com.system.cafe.dto.cafe;

import lombok.*;

/**
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HashtagCafeResponseDTO {

    private String uuid;

    private String name;

    private String address;

    private Double rating;
}
