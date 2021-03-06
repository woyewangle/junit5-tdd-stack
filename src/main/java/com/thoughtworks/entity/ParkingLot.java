package com.thoughtworks.entity;

import com.thoughtworks.exception.ParkingLotFullException;

import java.util.HashMap;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 4:32 PM 7/11/2018
 * @Modified By:
 */
public class ParkingLot {
    int size;
    HashMap<Receipt,Car> parkingCars=new HashMap<Receipt,Car>();
    public ParkingLot(int size) {
        this.size=size;
    }

    public Receipt park(Car car) {
        Receipt receipt=new Receipt();
        if(!isFull()){
            parkingCars.put(receipt,car);

        }else {
            throw new ParkingLotFullException();
        }
        return receipt;
    }



    //取车
    public Car unPark(Receipt receipt) {
        return  parkingCars.remove(receipt);
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Boolean isFull() {
        //return  size==0;
        return size==parkingCars.size();
    }


    public int getparkingCarsCount() {
        return parkingCars.size();
    }
}
