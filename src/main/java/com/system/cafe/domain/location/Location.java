package com.system.cafe.domain.location;

import com.system.cafe.domain.info.Info;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 위치
    @Column
    private String address;

    // 위도
    @Column
    private String latitude;

    // 경도
    @Column
    private String longitude;


}
