package io.dicehard.n20;

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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    private int offset = 0;
    private int sides = 1;
    private int weight = 0;

    //TODO: Eventually replace this with a "Roll" object array that captures all relevent roll info
    private int roll = 1;



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

    //METHOD CREATED TO RESOLVE ISSUE#3 (https://github.com/DiceHard/n20-android/issues/3)
    public int roll() {
        Random r = new Random();
        int roll = r.nextInt(this.getSides()) +1;

        //If the modulus is >= 1, it means that the total was more than sides and the modulus is used and we need to wrap around
        if(this.offset != 0){
            if ((roll+this.offset)%this.getSides() >= 1){
                roll = (roll+this.offset)%this.getSides();

            }
        }

        this.setRoll(roll);
        this.setOffset(roll);
        return roll;
    }

    //METHOD CREATED TO RESOLVE ISSUE#3 (https://github.com/DiceHard/n20-android/issues/3)
    public int roll(boolean offset) {
        Random r = new Random();
        int roll = r.nextInt(this.getSides()) +1;

        //If the modulus is >= 1, it means that the total was more than sides and the modulus is used and we need to wrap around
        if(this.offset != 0 && offset){
            if ((roll+this.offset)%this.getSides() >= 1){
                roll = (roll+this.offset)%this.getSides();
            }
        }

        this.setRoll(roll);
        this.setOffset(roll);
        return roll;
    }


    //Method created to support Issue #4. As user swipes, we increment roll by one.
    public void increment() {
        if (this.getRoll()+1 > this.getSides()){
            this.setRoll(1);
            this.setOffset(1);
        }else{
            this.setRoll(this.getRoll()+1);
            this.setOffset(this.getRoll()+1);
        }
    }

    //Method created to support Issue #4. As user swipes, we increment roll by one.
    public void decrement() {
        if (this.getRoll()-1 < 1){
            this.setRoll(this.getSides());
            this.setOffset(this.getSides());
        }else{
            this.setRoll(this.getRoll()-1);
            this.setOffset(this.getRoll()-1);
        }
    }
}
