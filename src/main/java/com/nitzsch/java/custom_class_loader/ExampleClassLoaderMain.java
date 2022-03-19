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
            // 使用loaderClass 会经过双亲委派流程 这时会被 AppClassLoader 优先加载掉
            Object obj_1 = customClassLoader.loadClass("com.nitzsch.java.custom_class_loader.Character").newInstance();
            // 使用findClass 则不会经过双亲委派 直接被指定的 customClassLoader 加载
            Object obj_2 = customClassLoader.findClass("com.nitzsch.java.custom_class_loader.Character").newInstance();
            System.out.println(obj_1.getClass().getClassLoader());
            System.out.println(obj_2.getClass().getClassLoader());
            // 解析类方法
            Method[] methods = obj_1.getClass().getDeclaredMethods();
            System.out.println(String.format("Methods of %s class:", obj_1.getClass().getName()));
            for (Method method : methods) {
                System.out.println(method.getName());
            }
        } catch (ClassFormatError e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
