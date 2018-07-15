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
    ArrayList<ParkingLot> parkingLotsList=new ArrayList<>();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
    }

    public ParkingBoy(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLotsList=parkingLotList;
    }

    public Receipt park(Car theCar) {
        Receipt receipt=new Receipt();
        for (int i=0;i<parkingLotsList.size();i++){
            if (!parkingLotsList.get(i).isFull()){
                receipt=parkingLotsList.get(i).park(theCar);
                break;
            }
        }
        return receipt;
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

    public ArrayList<ParkingLot> getParkingLotsList() {
        return parkingLotsList;
    }

    public void setParkingLotsList(ArrayList<ParkingLot> parkingLotsList) {
        this.parkingLotsList = parkingLotsList;
    }


}
