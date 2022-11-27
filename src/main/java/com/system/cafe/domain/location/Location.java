package com.system.cafe.domain.location;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "location")
@Entity
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
