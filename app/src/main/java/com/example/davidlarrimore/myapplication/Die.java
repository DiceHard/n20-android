package com.example.davidlarrimore.myapplication;

import java.util.Random;
/**
 * Created by ian on 7/7/16.
 */
public class Die {

    public static int roll() {
        Random r = new Random();
        int sides = 20;
        return r.nextInt(sides) +1;
    }
}