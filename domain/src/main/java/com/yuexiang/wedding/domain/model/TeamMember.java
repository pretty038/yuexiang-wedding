package com.yuexiang.wedding.domain.model;

import lombok.Data;

@Data
public class TeamMember {
    long id;
    String name;
    /**
     * 人员头像
     */
    String avatar_url;
    String description;
    String role;
    /**
     * 收藏数,
     */
    int liked;
    /**
     * 浏览数
     */
    int view;
    /**
     * '状态，1有效，0无效',
     */
    int status;
    String created;
    String modified;

}
