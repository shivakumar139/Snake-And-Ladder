package models;

public class Dice {
    public static int roll(){
        return (int)(Math.random()*6.0)+1;
    }
}
