package com.thoughtworks.parkingSystem.entity;

import java.util.UUID;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 4:44 PM 7/11/2018
 * @Modified By:
 */
public class Receipt {
    private String uuid = UUID.randomUUID().toString();

    public Receipt() {};

    public String getId() {
        return uuid;
    }

    public void setId(String uuid) {
        this.uuid = uuid;
    }
}
