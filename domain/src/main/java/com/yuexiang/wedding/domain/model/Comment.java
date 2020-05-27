package com.yuexiang.wedding.domain.model;

import lombok.Data;

@Data
public class Comment {
   long id;
   String openId;
   int objectId;
   int objectType;
    /**
     * 状态1正常显示,0已删除,-1隐藏
     */
   int status;
   int star;
   String content;
   String created;
   String modified;

}
