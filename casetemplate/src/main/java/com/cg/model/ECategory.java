package com.cg.model;

public enum ECategory {
    PHONE(1, "Điện thoại"), LAPTOP(2, "Máy tính bảng");

    private ECategory(long id, String name) {
        this.id = id;
        this.name = name;
    }

    private long id;
    private String name;
}
