package com.example.davidlarrimore.myapplication;

import java.util.Random;
/**
 * Created by ian on 7/7/16.
 */
public class Die {

    /**
     * Generic Constructor
     */
    private int sides = 0;

    public Die() {
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public static int roll() {
        Random r = new Random();
        int sides = 20;
        return r.nextInt(sides) +1;
    }

}