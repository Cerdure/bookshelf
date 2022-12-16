package com.cerdure.bookshelf.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    SUPERADMIN("ROLE_SUPERADMIN,ROLE_ADMIN"),
    ADMIN("ROLE_ADMIN");

    private String value;
}