package com.thoughtworks.tdd;

import com.thoughtworks.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;


public class ParkBoyTest {


    //判断parkingBoy可以停车,把车停在停车场
    @Test
    public void should_park_successfully_when_parkingLot_is_not_full_given_a_parkingLot() {
        Car theCar = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        try {
            parkingBoy.park(theCar);
        } catch (ParkingLotFullException exception) {
            fail("should park successfully");
        }

    }


    @Test
    public void should_getCar_successfully_when_the_car_in_parkingLot_parkingBoy_getCar_given_a_parkingLot() {
        Car theCar = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Receipt receipt=parkingBoy.park(theCar);
        Car car1=parkingBoy.getCar(receipt);
        assertThat(car1,is(theCar));
    }


    @Test
    public void should_getCar_fail_when_the_car_not_in_parkingLot_parkingBoy_getCar_given_a_parkingLot() {
        Car theCar = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Receipt receipt=parkingBoy.park(new Car());
        assertThat(parkingBoy.getCar(receipt),not(theCar));
    }

    @Test
    public void should_park_successfully_when_parkingLot_is_not_full__given_two_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        parkingLotList.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        try{
            parkingBoy.park(new Car());
            parkingBoy.park(new Car());
        }catch (ParkingLotFullException exception){
            fail("It should not throw exception!");
        }

    }


    @Test
    public void should_park_fail_when_parkingLot_is_full_given_two_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot1 = new ParkingLot(0);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        parkingLotList.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        try{
            parkingBoy.park(new Car());
            parkingBoy.park(new Car());
            fail("It should not throw exception!");
        }catch (ParkingLotFullException exception){
        }

    }

    @Test
    public void should_getCar_successfully_when_car_in_parkingLot_given_two_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        parkingLotList.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car theCar=new Car();
        Car theCar1=new Car();
        Receipt receipt=parkingBoy.park(theCar);
        Receipt receipt1=parkingBoy.park(theCar1);
        assertThat(parkingBoy.getCar(receipt),is(theCar));
        assertThat(parkingBoy.getCar(receipt1),is(theCar1));
    }


    @Test
    public void should_getCar_faid_when_receipt_is_Wrong__given_two_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        parkingLotList.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car theCar=new Car();
        Car theCar1=new Car();
        Receipt receipt=parkingBoy.park(theCar);
        Receipt receipt1=parkingBoy.park(theCar1);
        assertThat(parkingBoy.getCar(receipt1),not(theCar));
        assertThat(parkingBoy.getCar(receipt),not(theCar1));
    }















}





