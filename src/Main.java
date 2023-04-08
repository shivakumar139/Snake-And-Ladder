import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int snakeCount = sc.nextInt();

        Snake snake = Snake.getInstance();
        for(int i=1; i<=snakeCount; i++){
            int head = sc.nextInt();
            int tail = sc.nextInt();
            snake.add(head, tail);
        }


        int ladderCount = sc.nextInt();

        Ladder ladder = Ladder.getInstance();
        for(int i=1; i<=ladderCount; i++){
            int head = sc.nextInt();
            int tail = sc.nextInt();
            ladder.add(head, tail);
        }

        int playerCount = sc.nextInt();
        sc.nextLine();

        Player player = Player.getInstance();
        for(int i=1; i<= playerCount; i++){
            String name = sc.nextLine();
            player.add(name, i);
        }


        Board board = new Board(player);
//        System.out.println(board);

        while(!board.isGameOver()){
            int diceValue = Dice.roll();
            int currPlayerId = board.getCurrPlayer();
            int prevPotionOfPlayer = board.getPlayerPotionOnBoard(currPlayerId);

            board.setPlayerPositionOnBoard(currPlayerId, diceValue);

            String playerName = player.getName(currPlayerId);
            int newPositionOfPlayer = board.getPlayerPotionOnBoard(currPlayerId);

            System.out.println(playerName + " rolled a " + diceValue + " and moved from "+ prevPotionOfPlayer +" to " + newPositionOfPlayer);
            if(!board.isGameOver())
                board.nextPlayer();
        }


        String winnerName = player.getName(board.getWinnerId());
        System.out.println(winnerName + " wins the game");



    }


}
