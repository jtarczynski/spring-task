package com.deloitte.carApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Occupation {

    SALES_MAN("SALES_MAN"),
    MANAGER("MANAGER"),
    ACCOUNTANT("ACCOUNTANT");

    private final String occupation;
}
