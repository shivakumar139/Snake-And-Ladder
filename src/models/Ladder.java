package models;

import java.util.HashMap;

public class Ladder {
    private HashMap<Integer, Integer> ladders;
    private static Ladder ladderInstance;

    private Ladder(){
        this.ladders = new HashMap<>();
    }

    public static Ladder getInstance(){
        if(ladderInstance == null){
            ladderInstance = new Ladder();
        }

        return ladderInstance;
    }

    public void add(int start, int end){
        ladders.put(start, end);
    }
    public boolean hasLadder(int boardPosition){
        return ladders.containsKey(boardPosition);
    }

    public int getLadderEnd(int boardPosition){
        return ladders.get(boardPosition);
    }



    @Override
    public String toString() {
        return "Ladder{" +
                "ladders=" + ladders +
                '}';
    }
}
