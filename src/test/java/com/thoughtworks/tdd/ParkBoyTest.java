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
    public void should_park_successfully_when_parkingBoy_can_park_car_given_a_parkingLot() {
        Car theCar = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        try {
            parkingBoy.park(theCar);
        } catch (ParkingLotFullException exception) {
            fail("should park successfully");
        }

    }

    //判断parkBoy可以从车库取车
    @Test
    public void should_getCar_successfully_when_parkingBoy_getCar_given_a_parkingLot() {
        Car theCar = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Receipt receipt=new Receipt();
        try {
            receipt=parkingBoy.park(theCar);
        } catch (ParkingLotFullException exception) {
            fail("should park successfully");
        }
        assertThat(parkingBoy.getCar(receipt),is(theCar));
    }







}





