package com.nitzsch.java.binary_2_obj;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author: nitzschhong
 * @create: 2022-06-07 00:29
 */
public class Binary2Obj {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/Users/hongzeyang/Documents/dump_outputfile17.dump");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
