package com.yuexiang.wedding.domain.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    long id;
    String appKey,type,name,imageUrl;
}
