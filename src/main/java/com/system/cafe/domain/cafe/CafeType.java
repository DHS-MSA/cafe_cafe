package com.system.cafe.domain.cafe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CafeType {
    PERSONAL("개인 카페"),
    FRANCHISE("프랜차이즈");

    private final String description;

}
