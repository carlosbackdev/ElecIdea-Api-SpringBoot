

package com.example.ElecIdea.utils;

public class IDgenerador {
    public static int generadorId(){
        return (int)Math.floor(Math.random()*(999999999-100000000+1)+100000000);       
    }
}