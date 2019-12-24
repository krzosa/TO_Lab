package com.calculator;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

import static java.lang.System.exit;

public class Calc implements ICalc, Cloneable {

    Method meth;
    Object invokeObject;

    public Calc(){
        File filePath = new File("externalPluginsPath.txt");
        try
        {
            Scanner scanner = new Scanner(filePath);
            File file1 = new File(scanner.nextLine());
            scanner.close();
            //https://www.oracle.com/technical-resources/articles/java/javareflection.html
            //https://stackoverflow.com/questions/6219829/method-to-dynamically-load-java-class-files
            URL url = file1.toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);
            Class cls = cl.loadClass("Plugin");
            Method[] a = cls.getDeclaredMethods();

            Class partypes[] = new Class[2];
            partypes[0] = Double.TYPE;
            partypes[1] = Double.TYPE;
            meth = cls.getMethod("pow", partypes);
            invokeObject = cls.newInstance();
        }
        catch (Exception e)
        {
            System.out.println(e);
            exit(-1);
            /* TODO note and throw the exceprtion (????) */
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public double multiply(double a, double b) {
        return a*b;
    }

    @Override
    public double subtract(double a, double b) {
        return a-b;
    }

    @Override
    public double add(double a, double b) {
        return a+b;
    }

    @Override
    public double divide(double a, double b) {
        return a-b;
    }

    @Override
    public double pow(double x, double power){
        try{
            Object arglist[] = new Object[2];
            arglist[0] = x;
            arglist[1] = power;
            return (double)meth.invoke(invokeObject, arglist);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return -1;
        }
    }
}
