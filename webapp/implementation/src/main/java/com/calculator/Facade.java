package com.calculator;

public class Facade implements IFacade, Cloneable {

    ICalc calculator;
    public Facade(){
        try {
            calculator = new Calc();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        try {
            calculator = new Calc();
        }
        catch (Exception e){
            System.out.println(e);
        }
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


}
