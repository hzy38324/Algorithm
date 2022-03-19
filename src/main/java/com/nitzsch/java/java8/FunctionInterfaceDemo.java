package com.nitzsch.java.java8;

import java.util.function.Function;

/**
 * @author: nitzschhong
 * @create: 2022-03-13 10:48
 */
public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        Function<Integer,Double> squareRootGenerator = (input) -> {return Math.sqrt(input);};
        int input = 16;
        double result = squareRootGenerator.apply(input);
        System.out.println("Square Root of "+input+" is "+result);
    }
}
