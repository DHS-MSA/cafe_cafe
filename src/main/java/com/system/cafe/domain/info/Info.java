package com.system.cafe.domain.info;

import com.system.cafe.domain.BaseTimeEntity;
import com.system.cafe.domain.location.Location;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Info extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 유저 아이디
    @Column(length = 50, nullable = false)
    private String userId;

    // 타입
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CafeType type;

    // 카페 이름
    @Column(length = 30, nullable = false)
    private String name;

    // 평점
    @Column
    private Double rating;

    // 휴일
    @Column
    private LocalDateTime dayOff;

    // 영업 시간
    @Column(nullable = false)
    private LocalDateTime businessHour;

    // 전화 번호
    @Column(nullable = false)
    private String phoneNumber;

    // 주차장 여부
    @Column(length = 1)
    private String parkingYn;

    // 조회수
    @Column
    private int readCount;

    // 좋아요 수
    @Column
    private int likeCount;

    // 스크랩 수
    @Column
    private int scrapCount;

}
