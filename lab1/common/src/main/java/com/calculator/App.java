package com.calculator;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        ICalc calc = new Calc();
        Scanner scan = new Scanner(System.in);

        System.out.println("Type in a simple math problem ex. 1+2");
        while(true){
            String problem = scan.nextLine();
            calc.calculate(problem);
        }
    }
}
