package com.example.stepik_java;

import java.util.Arrays;

public class CallerClassAndMethodName {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod2();
    }

    private static void anotherMethod2() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        String result;
        try {
            throw new Exception("Just exception");
        } catch (Exception ex) {
            StackTraceElement[] elements = ex.getStackTrace();
            if (elements.length > 2) {
                StackTraceElement caller = elements[2];
                result = caller.getClassName() + "#" + caller.getMethodName();
            } else {
                result = null;
            }
        }
        return result;
    }
}
