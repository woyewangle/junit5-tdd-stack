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
    ArrayList<ParkingLot> parkingLotList=new ArrayList<>();

    public ParkingBoy(ArrayList<ParkingLot> parkingLotlist) {
        this.parkingLotList=parkingLotlist;
    }

    public Receipt park(Car theCar) {
        ParkingLot parkinglot = parkingLotList.get(0);
        return parkinglot.park(theCar);
    }


}
