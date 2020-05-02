package com.yuexiang.wedding.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    int id;
    String title,imgUrls,name,content;
    int typeId,status,inventory;
    float price;
}
