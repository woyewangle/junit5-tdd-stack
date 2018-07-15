package com.thoughtworks.parkingSystem.controller;

import com.thoughtworks.parkingSystem.ParkingSystemIO;
import com.thoughtworks.parkingSystem.entity.Car;
import com.thoughtworks.parkingSystem.entity.ParkingBoy;
import com.thoughtworks.parkingSystem.entity.Receipt;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 10:17 PM 7/15/2018
 * @Modified By:
 */
public class ParkControll {
    public ParkingBoy parkingBoy;

    public ParkControll(ParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public ParkingBoy getParkingBoy() {
        return parkingBoy;
    }

    public void setParkingBoy(ParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public static void incorrectInput(ParkingSystemIO systemIO) {
        systemIO.showErrorOrder();
    }

    private String getCarNo(ParkingSystemIO systemIO) {
        return systemIO.getOrder();
    }

    private String getReceiptId(ParkingSystemIO systemIO) {
        return systemIO.getOrder();
    }



    public void parkCar(ParkingSystemIO systemIO, ParkControll parkControll) {
        String carNo;
        if (isFull()) {
            systemIO.showParkingLotIsFull();
        } else {
            systemIO.askCarNo();
            carNo = parkControll.getCarNo(systemIO);
            Car car = new Car(carNo);
            Receipt receipt = parkingBoy.park(car);
            systemIO.showParkSuccessfully(receipt);
        }
    }


    public void getCar(ParkingSystemIO systemIO, ParkControll parkControll) {
        String receiptId;
        systemIO.askReceiptId();
        receiptId = parkControll.getReceiptId(systemIO);
        Receipt receipt = new Receipt();
        receipt.setId(receiptId);
        Car myCar = parkingBoy.getCar(receipt);
        if (myCar == null) {
            systemIO.getCarFailed();
        } else {
            systemIO.getCarSuccessfully(myCar);
        }
    }

    public boolean isFull() {
        return this.parkingBoy.allParkingLotIsFull();
    }

}
