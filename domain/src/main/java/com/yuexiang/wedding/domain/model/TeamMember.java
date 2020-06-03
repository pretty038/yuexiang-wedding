package com.yuexiang.wedding.domain.model;

import lombok.Data;

@Data
public class TeamMember {
    long id;
    String name;
    int age;
    String city;
    /**
     * 人员头像
     */
    String avatarUrl;
    String description;
    String role;
    int liked;
    int view;
    int orderNumber;
    int bookNumber;
    /**
     * '状态，1有效，0无效',
     */
    int status;
    String created;
    String modified;

}
