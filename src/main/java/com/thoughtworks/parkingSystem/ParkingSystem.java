package com.thoughtworks.parkingSystem;

import com.thoughtworks.parkingSystem.controller.ParkControll;
import com.thoughtworks.parkingSystem.entity.ParkingBoy;
import com.thoughtworks.parkingSystem.entity.ParkingLot;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 4:36 PM 7/13/2018
 * @Modified By:
 */
public class ParkingSystem {

    @Test
    public static void main(String[] args) {
        //初始化
        ParkingSystemIO systemIO  = new ParkingSystemIO();
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(2));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        ParkControll parkControll=new ParkControll(parkingBoy);

        while (true){
            systemIO.showstar();
            String order=systemIO.getOrder();
            if (order.equals("1")) {
                parkControll.parkCar(systemIO, parkControll);
            } else if (order.equals("2")) {
                parkControll.getCar(systemIO, parkControll);
            } else {
                parkControll.incorrectInput(systemIO);
            }
        }
    }
}
