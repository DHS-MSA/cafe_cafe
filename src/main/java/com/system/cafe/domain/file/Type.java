package com.system.cafe.domain.file;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {

    Profile("프로필 사진"), Info("카페 정보 사진"), Menu("카페 메뉴 사진");

    private final String description;
}
