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
        return this.sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int roll() {
        Random r = new Random();
        return r.nextInt(this.getSides()) +1;
    }

    public static int roll(int sides) {
        Random r = new Random();
        return r.nextInt(sides) +1;
    }

}