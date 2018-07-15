package com.thoughtworks.exception;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 4:36 PM 7/11/2018
 * @Modified By:
 */
public class ParkingLotFullException extends RuntimeException {
    private static final String caution = "车位已满，停车失败！";

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println(caution);
    }
}
