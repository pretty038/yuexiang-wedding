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
    double price;
    int liked;
    String team;
    int status;

}
