package com.thoughtworks.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 2:33 PM 7/12/2018
 * @Modified By:
 */
public class ParkingBoy {
    ParkingLot parkingLot;



    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
    }

    public Receipt park(Car theCar) {
        return this.parkingLot.park(theCar);
    }


    public Car getCar(Receipt receipt) {
        return this.parkingLot.unPark(receipt);
    }


    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
