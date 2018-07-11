package com.thoughtworks.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class FizzBuzzTest {

    @Test
    public  void  should_return_1_when_given_input_is_1(){
        //given
        int number=1;
        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("1"));
    }
    @Test
    public  void  should_return_Fizz_when_given_input_is_3(){
        //given
        int number=3;
        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("Fizz"));
    }

    @Test
    public  void  should_return__when_given_input_is_3(){
        //given
        int number=3;
        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("Fizz"));
    }

    @Test
    public  void  should_return_Fizz_when_given_input_is_6(){
        //given
        int number=6;
        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("Fizz"));
    }

    @Test
    public  void  should_return_Buzz_when_given_input_is_5(){
        //given
        int number=5;
        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("Buzz"));
    }
    @Test
    public  void  should_return_FizzBuzz_when_given_input_is_15(){
        //given
        int number=15;
        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("FizzBuzz"));
    }

    @Test
    public  void  should_return_Whizz_when_given_input_is_7(){
        //given
        int number=7;
        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("Whizz"));
    }
    @Test
    public  void  should_return_FizzWhizz_when_given_input_is_21(){
        //given
        int number=21;
        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("FizzWhizz"));
    }

    @Test
    public  void  should_return_BuzzWhizz_when_given_input_is_70(){
        //given
        int number=70;
        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("BuzzWhizz"));
    }

    @Test
    public  void  should_return_FizzBuzzWhizz_when_given_input_is_105(){
        //given
        int number=105;

        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("FizzBuzzWhizz"));
    }
    @Test
    public  void  should_return_Fizz_when_given_input_contains_3(){
        //given
        int number=38;

        FizzBuzz fizzBuzz=new FizzBuzz();
        //when
        String actual =fizzBuzz.fizzBuzz(number);

        //then
        assertThat(actual, is("Fizz"));
    }

}


