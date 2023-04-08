package models;

import java.util.Arrays;

public class Board {
    private int[][] board;
    private Player player;
    private int currPlayer = 1;

    public Board(Player players){
        player = players;
        int playerCount = player.getPlayerCount();
        board = new int[playerCount+1][1];
    }

    public void nextPlayer(){
        if(currPlayer < player.getPlayerCount()){
            currPlayer++;
        } else{
            currPlayer = 1;
        }
    }

    public int getCurrPlayer(){
        return currPlayer;
    }


    public void setPlayerPositionOnBoard(int playerId, int diceValue){
        Snake snake = Snake.getInstance();
        Ladder ladder = Ladder.getInstance();
        int newPosition = board[playerId][0]+diceValue;

        if(newPosition <= 100){
            // if we have snake at this position
            if(snake.hasSnake(newPosition)){
                System.out.println("**** Snake Ride Moved to " + snake.getSnakeTailPosition(newPosition) + "****");
                board[playerId][0] = snake.getSnakeTailPosition(newPosition);
            } else if(ladder.hasLadder(newPosition)){
                System.out.println("**** Ladder Ride Moved to " + ladder.getLadderEnd(newPosition) + "****");

                board[playerId][0] = ladder.getLadderEnd(newPosition);
            } else{
                board[playerId][0] = newPosition;
            }
        }

    }

    public int getPlayerPotionOnBoard(int playerId){
        return board[playerId][0];
    }

    public boolean isGameOver(){
        for(int[] players: board){
            if(players[0] == 100) return true;
        }

        return false;
    }

    public int getWinnerId(){
        int winnerId = -1;
        for(int i=1; i<=board.length; i++){
            if(board[i][0] == 100){
                winnerId = i;
                break;
            }
        }

        return winnerId;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                ", player=" + player +
                ", currPlayer=" + currPlayer +
                '}';
    }
}
