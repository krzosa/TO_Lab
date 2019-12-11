package com.calculator;

public class App
{
    public static void main( String[] args )
    {
        IFacade a = new Facade();
        System.out.println(a.pow(4,2));

        /* TODO: Loop and stuff */
    }
}

/* TODO Zastanowic sie jak wykorzystac ta apke jako api(Backend) i polaczyc ja z frontendem
    pana sie pytalem to spring tutaj jest potrzebny */