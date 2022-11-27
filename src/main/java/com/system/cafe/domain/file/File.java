package com.system.cafe.domain.file;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "file")
@Entity
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
    private Type type;

    // 확장자
    @Column(nullable = false)
    private String ext;
}
