package com.example.davidlarrimore.myapplication;

import java.util.Random;
/**
 * Created by ian on 7/7/16.
 */
public class Die {

    public int getSides() {
        return this.sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    private int sides = 0;
    private int weight = 0;

    //TODO: Eventually replace this with a "Roll" object array that captures all relevent roll info
    private int roll = 0;



    /**
     * Generic Constructor
     */
    public Die() {
    }


    public int roll() {
        Random r = new Random();
        return r.nextInt(this.getSides()) +1;
    }

    public static int roll(int sides) {
        Random r = new Random();
        return r.nextInt(sides) +1;
    }

    //METHOD CREATED TO RESOLVE ISSUE#3 (https://github.com/DiceHard/n20-android/issues/3)
    public static int roll(int sides, int offset) {
        Random r = new Random();
        int roll = r.nextInt(sides)+1;
        int thisRoll;

        //If the modulus is less than 1, it means that the total was less than sides and that is what is used.
        //If the modulus is 1 or higher, it means that the total was more than sides and the modulus is used.
        if ((roll+offset)%sides < 1){
            thisRoll = roll;
        }else{
            thisRoll = (roll+offset)%sides;
        }

        return thisRoll;
    }
}