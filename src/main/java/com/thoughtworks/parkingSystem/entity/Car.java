package com.thoughtworks.parkingSystem.entity;

public class Car {
    String carNo;
    public Car(String carNo) {
        this.carNo=carNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }
}

