package com.thoughtworks.entity;

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
        if(size>parkingCars.size()){
            parkingCars.put(receipt,car);
            this.size--;

        }else {
            throw new ParkingLotFullException();
        }
        return receipt;
    }

    //取车
    public Car unPark(Receipt receipt) {
        this.size++;
        return  parkingCars.remove(receipt);
    }


    public Boolean isFull() {
        //return  size==0;
        return size==parkingCars.size();
    }
}
