package com.calculator;

public class Facade implements IFacade, Cloneable {

    ICalc calculator;
    public Facade(){
        calculator = new Calc();
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        calculator = new Calc();    
        return super.clone();
    }

    @Override
    public double multiply(double a, double b) {
        return calculator.multiply(a,b);
    }

    @Override
    public double subtract(double a, double b) {
        return calculator.subtract(a,b);
    }

    @Override
    public double add(double a, double b) {
        return calculator.add(a,b);
    }

    @Override
    public double divide(double a, double b) {
        return calculator.divide(a,b);
    }

    @Override
    public double pow(double a, double power){
        return calculator.pow(a,power);
    }

}
