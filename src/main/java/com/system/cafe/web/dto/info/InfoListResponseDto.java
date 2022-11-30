package com.system.cafe.web.dto.info;

import com.system.cafe.domain.info.Info;
import com.system.cafe.domain.location.Location;
import com.system.cafe.domain.menu.Menu;
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


    public InfoListResponseDto(Info info, Location location){
        this.name = info.getName();
        this.address = location.getAddress();
        this.rating = info.getRating();

    }
}
