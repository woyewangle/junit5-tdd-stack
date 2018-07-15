package com.thoughtworks.entity;

import java.lang.reflect.Array;
import java.text.ParseException;
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



    public ParkingBoy(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLotsList=parkingLotList;
    }

    public Boolean allParkingLotIsFull(){
        int parkingLotsSumSize=0;//车位总数量
        int parkingCarsSumSzie=0;//当前停车的位置数量
        for (int i=0;i<parkingLotsList.size();i++){
            parkingLotsSumSize=+parkingLotsList.get(i).getSize();//车位总数量
            parkingCarsSumSzie=+parkingLotsList.get(i).getparkingCarsCount();
        }
        return parkingCarsSumSzie>=parkingLotsSumSize;
    }

    public Receipt park(Car theCar) {
        Receipt receipt=new Receipt();
        if(!allParkingLotIsFull()){
            for (int i=0;i<parkingLotsList.size();i++){
                if (!parkingLotsList.get(i).isFull()){
                    receipt=parkingLotsList.get(i).park(theCar);
                    break;
                }
            }
        }else {
            throw new ParkingLotFullException();
        }

        return receipt;
    }



    public Car getCar(Receipt receipt) {
        Car car=new Car();
        for(int i=0;i<parkingLotsList.size();i++){
            car=parkingLotsList.get(i).unPark(receipt);
            if (car!=null){
                break;
            }
        }
        return car;
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
