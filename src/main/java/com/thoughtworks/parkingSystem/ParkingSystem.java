package com.thoughtworks.parkingSystem;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 4:36 PM 7/13/2018
 * @Modified By:
 */
public class ParkingSystemMain {
    @Test
    public static void main(String[] args) {

        ParkingSystemIO systemIO  = new ParkingSystemIO();

        while (true){
            System.out.println("1.停车\n2.取车\n请输入您要进行的操作:" );
            Scanner in=new Scanner(System.in);
            int operation=in.nextInt();
            if(!(operation==1||operation==2)){
                System.out.println("非法指令，请查证后再输");
            }else {
                System.out.println("666");
                break;
            }
        }




    }
}
