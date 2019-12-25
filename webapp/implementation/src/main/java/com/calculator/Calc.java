package com.calculator;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.isDigit;
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
    //we are taking a math problem in string. We divide it into sections with "+" "-" as separators
    // (operators saved are into a buffer)
    //then we combine them from digits into numbers
    //lastly we use the operators that were saved into the buffer and output the result

    @Override
    public int calculate(String problem) {
        int problemLength = problem.length();
        List<Character> operators = new ArrayList<>();
        List<List<Integer>> numbersMason = new ArrayList<>();
        numbersMason.add(new ArrayList<>());
        int ii = 0;
        //dividing numbers into separate arrays with "+" etc. as separators
        for(int i = 0; i<problemLength;i++){

            if(isDigit(problem.charAt(i))){
                numbersMason.get(ii).add(Character.getNumericValue(problem.charAt(i)));
            }
            else if(problem.charAt(i)=='+'){
                operators.add('+');
                numbersMason.add(new ArrayList<>());
                ii++;
            }
            else if(problem.charAt(i)=='-'){
                operators.add('-');
                numbersMason.add(new ArrayList<>());
                ii++;
            }
            else if(problem.charAt(i)=='*'){
                operators.add('*');
                numbersMason.add(new ArrayList<>());
                ii++;
            }
            else if(problem.charAt(i)=='/'){
                operators.add('/');
                numbersMason.add(new ArrayList<>());
                ii++;
            }
        }
        int result = 0;
        int power = 0;
        //converting array of digits into their number counterparts
        for(int i = numbersMason.size()-1;i>=0;i--){
            power = 0;
            for(int j = numbersMason.get(i).size()-1;j>=0;j--){
                numbersMason.get(i).set(j, (int) (numbersMason.get(i).get(j)*Math.pow(10,power)));
                power++;
            }
        }
        //adding the numbers that we got
        for(int i = numbersMason.size()-1;i>=0;i--){
            power = 0;
            for(int j = numbersMason.get(i).size()-1;j>0;j--){
                numbersMason.get(i).set(0, (int) (numbersMason.get(i).get(0)+numbersMason.get(i).get(j)));
                power++;
            }
        }
        //here we are operating on the numbers with operators that were saved in a buffer
        result = numbersMason.get(0).get(0);
        for(int i = 0; i<numbersMason.size()-1;i++){
            switch(operators.get(i)){
                case '+':
                    result+=numbersMason.get(i+1).get(0);
                    break;
                case '-':
                    result-=numbersMason.get(i+1).get(0);
                    break;
                case '*':
                    result*=numbersMason.get(i+1).get(0);
                    break;
                case '/':
                    result/=numbersMason.get(i+1).get(0);
                    break;
            }
        }
        return result;
    }
}
