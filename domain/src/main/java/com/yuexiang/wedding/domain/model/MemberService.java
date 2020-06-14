package com.yuexiang.wedding.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class MemberService {
    int id;
    int memberId;
    String serviceName;
    String description;
    double price;
    String unit;
    int status;
}
