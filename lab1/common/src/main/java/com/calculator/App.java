package com.calculator;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import static java.lang.System.exit;

public class App
{
    public static void main( String[] args )
    {
        ICalc a = new Calc();
        System.out.println(a.pow(3,2));


    }
}
