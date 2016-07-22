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

    /**
     * Generic Constructor
     */
    public Die(int sides) {
        this.setSides(sides);
    }

    public int roll() {
        Random r = new Random();
        return r.nextInt(this.getSides()) +1;
    }

    //METHOD CREATED TO RESOLVE ISSUE#3 (https://github.com/DiceHard/n20-android/issues/3)
    public int roll(int offset) {
        Random r = new Random();
        int roll = r.nextInt(this.getSides())+1;
        int thisRoll;

        //If the modulus is less than 1, it means that the total was less than sides and that is what is used.
        //If the modulus is 1 or higher, it means that the total was more than sides and the modulus is used.
        if ((roll+offset)%this.getSides() < 1){
            return roll;
        }else{
            return (roll+offset)%this.getSides();
        }
    }

    //Method created to support Issue #4. As user swipes, we increment roll by one.
    public void increment() {
        if (this.getRoll()+1 > this.getSides()){
            this.setRoll(1);
        }else{
            this.setRoll(this.getRoll()+1);
        }
    }

    //Method created to support Issue #4. As user swipes, we increment roll by one.
    public void decrement() {
        if (this.getRoll()-1 < 1){
            this.setRoll(this.getSides());
        }else{
            this.setRoll(this.getRoll()-1);
        }
    }
}