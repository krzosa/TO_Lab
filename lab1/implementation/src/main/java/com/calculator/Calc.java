package com.calculator;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import static java.lang.System.exit;

public class Calc implements ICalc {

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
        File file1 = new File("plugins/plugin/target/classes");
        try
        {
            //https://www.oracle.com/technical-resources/articles/java/javareflection.html
            //https://stackoverflow.com/questions/6219829/method-to-dynamically-load-java-class-files
            URL url = file1.toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);
            Class cls = cl.loadClass("Plugin");
            Method[] a = cls.getDeclaredMethods();
            System.out.println(a[0].toString());

            Class partypes[] = new Class[2];
            partypes[0] = Double.TYPE;
            partypes[1] = Double.TYPE;
            Method meth = cls.getMethod(
                    "pow", partypes);
            Object invokeObject = cls.newInstance();
            Object arglist[] = new Object[2];
            arglist[0] = new Double(x);
            arglist[1] = new Double(power);
            return (double)meth.invoke(invokeObject, arglist);
        }
        catch (Exception e)
        {
            System.out.println("LOADING ERROR");
            System.out.println(e);
            exit(1);
            return -1;
        }
    }
}
