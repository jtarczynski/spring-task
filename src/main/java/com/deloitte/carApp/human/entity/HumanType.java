package com.deloitte.carApp.human.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HumanType {

    WORKER(Values.WORKER),
    CLIENT(Values.CLIENT);

    private final String value;

    public static class Values {
        public static final String WORKER = "WORKER";
        public static final String CLIENT = "CLIENT";
    }
}
