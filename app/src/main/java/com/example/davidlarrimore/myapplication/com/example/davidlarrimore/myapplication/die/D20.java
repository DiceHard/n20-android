package com.example.davidlarrimore.myapplication.com.example.davidlarrimore.myapplication.die;

import com.example.davidlarrimore.myapplication.Die;

/**
 * Created by David Larrimore on 7/7/2016.
 */
public class D20 extends Die{

    public D20() {
        this.setSides(20);
        this.setRoll(this.roll(this.getSides()));
    }


}
