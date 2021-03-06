package com.thoughtworks.parkingSystem.entity;

import com.thoughtworks.parkingSystem.entity.Car;
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
    HashMap<String,Car> parkingCars=new HashMap<String,Car>();
    public ParkingLot(int size) {
        this.size=size;
    }

    public Receipt park(Car car) {
        Receipt receipt=new Receipt();
        if(!isFull()){
            parkingCars.put(receipt.getId(),car);
        }else {
            throw new ParkingLotFullException();
        }
        return receipt;
    }



    //取车
    public Car unPark(Receipt receipt) {
        return  parkingCars.remove(receipt.getId());
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
