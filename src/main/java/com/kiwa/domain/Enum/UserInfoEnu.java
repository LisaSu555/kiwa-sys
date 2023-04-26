package com.kiwa.domain.Enum;

import lombok.Getter;

@Getter
public enum UserInfoEnu {
    user("name"),
    pass("pass");
    private final String code;

    UserInfoEnu(String code) {
        this.code = code;
    }
}
