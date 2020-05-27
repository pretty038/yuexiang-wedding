package com.yuexiang.wedding.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Case {
    long id;
    String name;
    String imageUrl;
    String description;
    String tags;
    double initPrice;
    double price;
    int liked;
    long view;
    String team;
    int status;
}
