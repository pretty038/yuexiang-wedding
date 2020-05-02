package com.yuexiang.wedding.domain.model;

import lombok.Data;


@Data
public class Address {

    private int id;
    private String name ;
    private String phone;
    private int areaId;
    private int userId;
    private String street;
    private String created;
    private String modified;
    private int isFirst;

}
