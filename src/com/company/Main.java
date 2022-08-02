//Создать аннотацию, которая принимает параметры для метода.
//Написать код, который вызовет метод, помеченный этой аннотацией,
// и передаст параметры аннотации в вызываемый метод.

package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Class<?> cls = MyTest.class;
        MyTest mt = new MyTest();

        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
//          if ((method.getName().equals("test"))
                Test myAnnotation = method.getAnnotation(Test.class);

                try {
                    method.invoke(mt, myAnnotation.a(), myAnnotation.b());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyTest {

    @Test(a = 2, b = 5)
    public void test(int a, int b) {
        System.out.println("arg1: " + a);
        System.out.println("arg2: " + b);
    }
}
