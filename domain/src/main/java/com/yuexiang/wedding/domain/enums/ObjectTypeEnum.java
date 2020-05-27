package com.yuexiang.wedding.domain.enums;

public enum ObjectTypeEnum {
    //案例
    WEDDINGCASE(1,"案例"),
    //人员
    TEAMMEMBER(2,"人员");

    int code;
    String name;

    ObjectTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
