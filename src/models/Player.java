package models;

import java.util.HashMap;

public class Player {
    private HashMap<Integer, String> players;

    private static Player playerInstance;

    private Player(){
        players = new HashMap<>();
    }

    public static Player getInstance(){
        if(playerInstance == null){
            playerInstance = new Player();
        }

        return playerInstance;
    }

    public void add(String name, int position){
        players.put(position, name);
    }

    public String getName(int position){
        return players.get(position);
    }
    public int getPlayerCount(){
        return players.size();
    }

    @Override
    public String toString() {
        return "Player{" +
                "players=" + players +
                '}';
    }
}
