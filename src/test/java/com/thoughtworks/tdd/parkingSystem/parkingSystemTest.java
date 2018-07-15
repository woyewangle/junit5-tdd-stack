package com.thoughtworks.tdd.parkingSystem;

import com.sun.xml.internal.fastinfoset.tools.TransformInputOutput;
import com.thoughtworks.parkingSystem.ParkingSystem;
import com.thoughtworks.parkingSystem.ParkingSystemIO;
import com.thoughtworks.parkingSystem.controller.ParkControll;
import com.thoughtworks.parkingSystem.entity.ParkingBoy;
import com.thoughtworks.parkingSystem.entity.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 11:23 PM 7/15/2018
 * @Modified By:
 */
public class parkingSystemTest {
    @Test
    public void should_return_false_when_input_is_incorrect() {
        //ParkingSystem parkingSystem = new ParkingSystem();
        ArrayList<ParkingLot> parkingLotList = new ArrayList<>();
        ParkControll parkControll = new ParkControll(new ParkingBoy(parkingLotList));
        ParkingSystemIO systemIO = mock(ParkingSystemIO.class);
        when(systemIO.getOrder()).thenReturn("45");

        String order = systemIO.getOrder();
        assertThat(order, is("45"));
    }

    @Test
    public void should_return_1_when_input_is_correct() {
        ArrayList<ParkingLot> parkingLotList = new ArrayList<>();
        ParkControll parkControll = new ParkControll(new ParkingBoy(parkingLotList));
        ParkingSystemIO systemIO = mock(ParkingSystemIO.class);
        when(systemIO.getOrder()).thenReturn("1");

        String order = systemIO.getOrder();
        assertThat(order, is("1"));
    }


    @Test
    public void should_return_2_when_input_is_correct() {
        ArrayList<ParkingLot> parkingLotList = new ArrayList<>();
        ParkControll parkControll = new ParkControll(new ParkingBoy(parkingLotList));
        ParkingSystemIO systemIO = mock(ParkingSystemIO.class);
        when(systemIO.getOrder()).thenReturn("2");

        String order = systemIO.getOrder();
        assertThat(order, is("2"));
    }



}
