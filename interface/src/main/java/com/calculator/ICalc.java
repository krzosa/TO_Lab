package com.calculator;

import java.lang.reflect.InvocationTargetException;

public interface ICalc {
    double multiply(double a, double b);
    double subtract(double a, double b);
    double add(double a, double b);
    double divide(double a, double b);
//    double pow(double a, double pow) throws InvocationTargetException, IllegalAccessException;
    int calculate(String problem);
}
