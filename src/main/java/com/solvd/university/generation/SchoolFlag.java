package com.solvd.university.generation;

import java.util.Random;

public enum SchoolFlag {

    INSTATE(true),
    OUTOFSTATE(false);


    private final boolean flag;

    SchoolFlag(boolean flag) {
        this.flag = flag;
    }

    //Will return a random flag, true or false
    public static SchoolFlag returnRandomFlag() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public boolean getFlag(){
        return this.flag;
    }
}
