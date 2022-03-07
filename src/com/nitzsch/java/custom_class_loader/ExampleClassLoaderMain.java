package com.nitzsch.java.custom_class_loader;

import java.lang.reflect.Method;

/**
 * @author: nitzschhong
 * @create: 2022-03-07 23:31
 */
public class ExampleClassLoaderMain {
    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Object obj;
            obj = customClassLoader.findClass("com.nitzsch.java.custom_class_loader.Character").newInstance();
            Method[] methods = obj.getClass().getDeclaredMethods();
            System.out.println(String.format("Methods of %s class:",obj.getClass().getName()));
            for(Method method : methods) {
                System.out.println(method.getName());
            }
        } catch (ClassFormatError e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
