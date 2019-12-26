package com.calculator;

public interface ICalc {
    int multiply(int a, int b);
    int subtract(int a, int b);
    int add(int a, int b);
    int divide(int a, int b);
    int pow(int a, int pow);
    int calculate(String problem);
}
