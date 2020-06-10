package com.yuexiang.wedding.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Price {
    int id;
    int caseId;
    String name;
    int price;
    String type;
    int status;
}
