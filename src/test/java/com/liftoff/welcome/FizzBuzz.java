package com.liftoff.welcome;

import java.sql.SQLOutput;

public class FizzBuzz {

    public static void main(String[] args){
        // 1- 100
        // #/3    "Fizz"
        // #/5    "Buzz"
        // #/15    "FizzBuzz"
        // not /3,/5,/15   int

        for (int i = 1; i<101;i++){
            if (i%15==0){
                System.out.println("FizzBuzz");
            } else if (i%3==0){
                System.out.println("Fizz");
            } else if (i%5==0){
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

}
