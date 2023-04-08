package models;

import java.util.HashMap;

public class Snake {
    private HashMap<Integer, Integer> snakes;
    private static Snake snakeInstance;
    private Snake(){
        this.snakes = new HashMap<>();
    }

    public static Snake getInstance(){
        if(snakeInstance == null){
            snakeInstance = new Snake();
        }
        return snakeInstance;
    }

    public void add(int head, int tail){
        snakes.put(head, tail);
    }
    public boolean hasSnake(int boardPosition){
        return snakes.containsKey(boardPosition);
    }

    public int getSnakeTailPosition(int boardPosition){
        return snakes.get(boardPosition);
    }

    @Override
    public String toString() {
        return "Snake{" +
                "snakes=" + snakes +
                '}';
    }
}
