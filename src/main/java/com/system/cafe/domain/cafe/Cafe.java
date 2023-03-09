package com.system.cafe.domain.cafe;

import com.system.cafe.domain.BaseTimeEntity;
import com.system.cafe.domain.menu.Menu;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = false)
@Entity
@Table(name = "cafe")
public class Cafe extends BaseTimeEntity {

    @Id
    @Column(name = "cafe_uuid")
    private String uuid;

    @Column(length = 50, nullable = false)
    private String userId; // 유저 아이디

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CafeType type; // 타입

    @Column(length = 30, nullable = false)
    private String name; // 카페 이름

    // 평점
    @Column
    private Double rating;

    // 휴일
    @Column
    private String dayOff;

    // 영업 시간
    @Column(nullable = false)
    private LocalTime businessStart;

    @Column(nullable = false)
    private LocalTime businessEnd;


    // 전화 번호
    @Column(nullable = false)
    private String phoneNumber;

    private String direction;

    private String openYn;

    // 조회수
    private Long readCount;

    // 좋아요 수
    private Long likeCount;
    private String address;
    private String latitude;
    private String longitude;

//    @OneToMany(mappedBy = "cafe")
//    private List<Menu> menuList = new ArrayList<>();
}
