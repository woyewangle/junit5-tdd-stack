package com.thoughtworks.tdd.parkingSystem;

import com.thoughtworks.parkingSystem.entity.Car;
import com.thoughtworks.parkingSystem.entity.ParkingBoy;
import com.thoughtworks.parkingSystem.entity.ParkingLot;
import com.thoughtworks.parkingSystem.entity.Receipt;
import com.thoughtworks.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ParkBoyTest {


    //判断parkingBoy可以停车,把车停在停车场
    @Test
    public void should_park_successfully_when_parkingLot_is_not_full_given_a_parkingLot() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        when(parkingLot.getSize()).thenReturn(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        Car theCar=mock(Car.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        try {
            parkingBoy.park(theCar);
        } catch (ParkingLotFullException exception) {
            fail("should park successfully");
        }

    }

    @Test
    public void should_park_fail_when_parkingLot_is_full_given_a_parkingLot() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        when(parkingLot.getSize()).thenReturn(0);
        when(parkingLot.park(any())).thenReturn(mock(Receipt.class));
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        Car theCar=mock(Car.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        try {
            parkingBoy.park(theCar);
        } catch (ParkingLotFullException exception) {
            return;
        }
        fail("所有停车场都没有车位时，应当抛出异常！");

    }
//
//
    @Test
    public void should_getCar_successfully_when_the_car_parked_in_parkingLot_given_a_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        Car theCar=mock(Car.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Receipt receipt=parkingBoy.park(theCar);
        Car car1=parkingBoy.getCar(receipt);
        assertThat(car1,is(theCar));
    }
//
//
    @Test
    public void should_getCar_fail_when_the_car_not_in_parkingLot_parkingBoy_getCar_given_a_parkingLot() {
        Car theCar = new Car("111");
        ParkingLot parkingLot = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Receipt receipt=parkingBoy.park(new Car("2222"));
        assertThat(parkingBoy.getCar(receipt),not(theCar));
    }
//
    @Test
    public void should_park_successfully_when_parkingLot_is_not_full__given_two_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        parkingLotList.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        try{
            parkingBoy.park(new Car("111"));
            parkingBoy.park(new Car("222"));
        }catch (ParkingLotFullException exception){
            System.err.println("It should not throw exception!");
        }

    }
//
//
    @Test
    public void should_park_fail_when_parkingLot_is_full_given_two_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot1 = new ParkingLot(0);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        parkingLotList.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        try{
            parkingBoy.park(new Car("111"));
            parkingBoy.park(new Car("222"));
        }catch (ParkingLotFullException exception){
            System.err.println("All parkingLots are full,you can't park any more!!!");
        }

    }
//
    @Test
    public void should_getCar_successfully_when_car_in_parkingLot_given_two_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        parkingLotList.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car theCar=new Car("111");
        Car theCar1=new Car("222");
        Receipt receipt=parkingBoy.park(theCar);
        Receipt receipt1=parkingBoy.park(theCar1);
        assertThat(parkingBoy.getCar(receipt),is(theCar));
        assertThat(parkingBoy.getCar(receipt1),is(theCar1));
    }
//

    @Test
    public void should_getCar_faid_when_receipt_is_Wrong__given_two_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot);
        parkingLotList.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car theCar=new Car("111");
        Car theCar1=new Car("222");
        Receipt receipt=parkingBoy.park(theCar);
        Receipt receipt1=parkingBoy.park(theCar1);
        assertThat(parkingBoy.getCar(receipt1),not(theCar));
        assertThat(parkingBoy.getCar(receipt),not(theCar1));
    }
//
    @Test
    public void should_return_true_when_the_car_is_the_one_from_lot1() {

        ParkingLot parkingLot1 = mock(ParkingLot.class);
        ParkingLot parkingLot2 = mock(ParkingLot.class);
        ArrayList<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        when(parkingLot1.isFull()).thenReturn(false,true);
        when(parkingLot2.isFull()).thenReturn(false,true);
        Car car = new Car("111");
        Receipt receipt1 = parkingBoy.park(car);
        Receipt receipt2 = parkingBoy.park(car);
        InOrder inOrder = Mockito.inOrder(parkingLot1,parkingLot2);
        inOrder.verify(parkingLot1).park(car);
        inOrder.verify(parkingLot2).park(car);
    }















}





