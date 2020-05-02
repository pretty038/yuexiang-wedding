package com.yuexiang.wedding.domain.model;

import lombok.Data;

/**
 * @author gaoxiaoning
 * @version ${version}
 * @createdDate 2019/4/11
 */
@Data
public class ShopingOrder {

    private int id;
    private int userId;
    private String productDetailList;
    private float totalMoney;
    private int status;
    private int addressId;
    private String created;
    private String modified;
}
