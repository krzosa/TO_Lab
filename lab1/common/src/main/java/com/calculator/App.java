package com.calculator;

public class App
{
    public static void main( String[] args )
    {
        IFacade a = new Facade();
        System.out.println(a.pow(4,2));


    }
}
