package com.thoughtworks.tdd.parkingSystem;

import com.thoughtworks.parkingSystem.entity.Car;
import com.thoughtworks.parkingSystem.entity.ParkingLot;
import com.thoughtworks.parkingSystem.entity.Receipt;
import com.thoughtworks.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ParkingLotTest {

    @Test
    public void should_park_successfully_given_parking_lot_is_not_full() {
        ParkingLot parkingLot = new ParkingLot(1);

        try {
            parkingLot.park(new Car("111"));
        } catch (ParkingLotFullException exception) {
            fail("should park successfully");
        }

    }

    @Test
    public void should_park_failed_given_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(0);

        try {
            parkingLot.park(new Car("111"));
            fail("should park successfully");
        } catch (ParkingLotFullException exception) {

        }
    }

    @Test
    public void should_get_specific_car_when_call_unPark_given_receipt_is_right() {
        ParkingLot parkingLot = new ParkingLot(1);

        Car theCar = new Car("111");
        Receipt receipt = parkingLot.park(theCar);

        assertThat(parkingLot.unPark(receipt), is(theCar));

    }
//
    @Test
    public void should_be_true_when_call_isFull_given_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(0);
        assertThat(parkingLot.isFull(), is(true));
    }
//
//
    @Test
    public void should_be_false_when_call_isFull_given_parking_lot_is_not_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertThat(parkingLot.isFull(), is(false));
    }
//
    @Test
    public void should_be_false_when_call_isFull_given_a_full_parking_lot_take_out_a_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car theCar = new Car("111");
        Receipt receipt = parkingLot.park(theCar);
        parkingLot.unPark(receipt);
        assertThat(parkingLot.isFull(), is(false));
    }
//

    @Test
    public void should_park_fail_when_call_park_again_given_a_full_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car theCar = new Car("111");
        Receipt receipt = parkingLot.park(theCar);
        try {
            parkingLot.park(new Car("222"));
            fail("should park fail");
        } catch (ParkingLotFullException exception) {

        }
    }
    @Test
    public void should_park_successfullly_when_call_park_again_given_a_full_parking_lot_take_out_a_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car theCar = new Car("111");
        Receipt receipt = parkingLot.park(theCar);
        parkingLot.unPark(receipt);
        try {
            parkingLot.park(new Car("222"));
        } catch (ParkingLotFullException exception) {
            fail("should park successfully");
        }
    }






//    @Test
//    public void should_park_three_car_successful_when_given_two_parking_size_is_2(){
//        ParkingLot parkingLot = new ParkingLot(2);
//        ParkingLot parkingLot1 = new ParkingLot(2);
//        Car theCar = new Car();
//        Receipt receipt = parkingLot.park(theCar,parkingLot);
//        Car theCar1 = new Car();
//        Receipt receipt1 = parkingLot.park(theCar1,parkingLot);
//        Car theCar2=new Car();
//        Receipt receipt2=parkingLot.park(theCar2,parkingLot1);
//        try {
//            //这里多放3辆车，发生异常
//            parkingLot.park(new Car());
//        } catch (ParkingLotFullException exception) {
//            fail("should park successfully");
//            //将第三辆成
//        }


//
//    public static void shoudNotThrowException(){
//        //throw new ParkingLotFullException();
//    }
//    @Test
//    public void should_fail(){
//
//        System.out.println("Hello I am OK");
//        try {
//            shoudNotThrowException();
//        } catch (ParkingLotFullException e) {
//            System.out.println("Hello I am in catch");
//            fail("it failed");
//        }
//        System.out.println("Hello I am called");
//
//    }


    //测试能否停车
//    @Test
//    public  void  should_return_trueOrFalse_when_given_parking(){
//        //given
//        Parking parking=new Parking(5,1);
//        Car car=new Car("不在车库");
//        //when
//        Boolean actual =parking.canPark(6);
//        //then
//        //assertThat(actual, is("false"));
//        actual.equals("false");
//    }

//    //判断该车在不在车库
//    @Test
//    public  void  should_return_trueOrFalse_when_given_parking(){
//        //given
//        Parking parking=new Parking(5,1);
//        Car car=new Car("不在车库");
//        //when
//        Boolean actual =parking.isInPark(car);
//        //then
//        //assertThat(actual, is("false"));
//        actual.equals("false");
//    }


    //测试能否停车
//    @Test
//    public  void  should_return_canParkResult_when_parkCar_given_parking(){
//        //given
//        Parking parking=new Parking(5,1);
//        Car car=new Car("不在车库");
//        //when
//        String actual =parking.parkCar(car,4);
//        //then
//        assertThat(actual, is("停车成功，拿到小票"));
//    }
//
//
//
//    @Test
//    public  void  should_return_canNotParkResult_when_parkCar_given_parking(){
//        //given
//        Parking parking=new Parking(5,1);
//        Car car=new Car("不在车库");
//        //when
//        String actual =parking.parkCar(car,8);
//        //then
//        assertThat(actual, is("车位已满，不能停车"));
//    }
//
//
//    @Test
//    public  void  should_return_inParkResult_when_parkCar_given_parking(){
//        //given
//        Parking parking=new Parking(5,1);
//        Car car=new Car("在车库");
//        //when
//        //then
//        String actual =parking.parkCar(car,8);
//        assertThat(actual, is("停车失败，该车已在车库"));
//    }
//
//    @Test
//    public  void  should_return_notInParkResult_when_getCar_given_parking(){
//        //given
//        Parking parking=new Parking(5,1);
//        Car car=new Car("不在车库");
//        //when
//        String actual =parking.getCar(car);
//        //then
//        assertThat(actual, is("取车失败，车子不在车库"));
//    }
}





