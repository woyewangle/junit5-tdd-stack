package com.thoughtworks.tdd.parkingSystem;

import com.thoughtworks.parkingSystem.ParkingSystemIO;
import com.thoughtworks.parkingSystem.controller.ParkControll;
import com.thoughtworks.parkingSystem.entity.Car;
import com.thoughtworks.parkingSystem.entity.ParkingBoy;
import com.thoughtworks.parkingSystem.entity.ParkingLot;
import com.thoughtworks.parkingSystem.entity.Receipt;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 1:52 AM 7/16/2018
 * @Modified By:
 */
public class parkControllTest {

    @Test
    public void should_return_true_when_parkingLot_is_full() {


        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkControll parkControll = new ParkControll(parkingBoy);
        ParkingSystemIO systemIO = mock(ParkingSystemIO.class);
        when(parkingBoy.allParkingLotIsFull()).thenReturn(true);
        assertThat(parkControll.isFull(), is(true));
    }




}
