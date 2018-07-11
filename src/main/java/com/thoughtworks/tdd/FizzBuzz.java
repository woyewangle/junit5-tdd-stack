package com.thoughtworks.tdd;

/**
 * Created by twer on 3/28/14.
 */
public class FizzBuzz {


    public String fizzBuzz(int number) {
        StringBuffer temp = new StringBuffer();
        if(String.valueOf(number).contains("3")){
            return "Fizz";
        }
        if(number%3==0){
            temp.append("Fizz");
        }
        if(number%5==0){
            temp.append("Buzz");
        }
        if(number%7==0){
            temp.append("Whizz");
        }
        return "".equals(temp.toString()) ? String.valueOf(number) : String.valueOf(temp);
    }

}
