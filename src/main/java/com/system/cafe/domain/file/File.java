package com.system.cafe.domain.file;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 유저 아이디
    @Column(length = 50, nullable = false)
    private String userId;

    // 파일 이름
    @Column(length = 50, nullable = false)
    private String name;

    // 타입
    @Enumerated(EnumType.STRING)
    @Column
    private FileType type;

    // 확장자
    @Column(nullable = false)
    private String ext;
}
