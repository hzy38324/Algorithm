package com.nitzsch.java.others;

/**
 * @author: nitzschhong
 * @create: 2022-08-09 21:49
 */
public class Test {
    public static void main(String[] args) {
        try {
            String s = "hi you are";
            System.out.println(s.indexOf("you"));
        } catch (Exception e) {
            throw e;
        }
    }
}
