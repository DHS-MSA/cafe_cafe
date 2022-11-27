package com.system.cafe.domain.info;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CafeType {
    Personal("개인 카페"), Franchise("프랜차이즈");

    private final String description;

}
