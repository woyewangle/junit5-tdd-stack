package com.thoughtworks.parkingSystem;

import com.thoughtworks.parkingSystem.entity.Car;
import com.thoughtworks.parkingSystem.entity.Receipt;

import java.util.Scanner;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 8:53 PM 7/15/2018
 * @Modified By:
 */
public class ParkingSystemIO {

    public void showstar() {
        System.out.println("1.停车\n2.取车\n请输入您要进行的操作:" );
    }

    public String getOrder() {
        Scanner in = new Scanner(System.in);
        String order = in.nextLine();
        return order;
    }


    public void showErrorOrder() {
        System.out.println("非法指令，请查证后再输");
    }


    public void showParkingLotIsFull() {
        System.out.println("车已停满，请晚点再来");
    }

    public void askCarNo() {
        System.out.println("请输入车牌号:");
    }

    public void showParkSuccessfully(Receipt receipt) {
        System.out.println("停车成功，您的小票是：\n"+receipt.getId());
    }

    public void askReceiptId() {
        System.out.printf("请输入小票编号：");
    }

    public void getCarFailed() {
        System.out.println("非法小票，无法取出车，请查证后再输");
    }

    public void getCarSuccessfully(Car myCar) {
        System.out.println("车已取出，您的车牌号是：" + myCar.getCarNo());
    }
}
