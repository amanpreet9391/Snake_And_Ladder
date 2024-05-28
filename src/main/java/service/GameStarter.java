package service;

import SnakeAndLadder.InvalidValusForDiesException;
import models.*;

import java.util.*;


public class GameStarter {

    public static Map<Integer, Player> playerMap = new HashMap<>();

    public static void startGame() throws InvalidValusForDiesException, service.InvalidValusForDiesException {
        Scanner sc = new Scanner(System.in);

        //Snake Input
        System.out.println("Enter the number of snakes");
        int s = sc.nextInt();
        Snake snake = new Snake(s);
        Map<Integer,Integer> snakeTrack = new HashMap<>();
        for(int i=0;i<s;i++){
            int head = sc.nextInt();
            int tail = sc.nextInt();
            snakeTrack.put(head,tail);
        }
        snake.setSnakeTrack(snakeTrack);

//        //Ladder input
        System.out.println("Enter the number of ladders");
        int l = sc.nextInt();
        Ladder ladder = new Ladder(l);
        Map<Integer,Integer> ladders = new HashMap<>();
        for(int j=0;j<l;j++){
            int bottom = sc.nextInt();
            int top = sc.nextInt();
            ladders.put(bottom,top);
        }
        ladder.setLadders(ladders);

        //Player Input
        System.out.println("Enter the number of players");
        int n = sc.nextInt();
        for(int k=0;k<n;k++){
            String name = sc.next();
            int startingPosition = sc.nextInt();
            Player player = new Player(name,startingPosition);
            playerMap.put(k,player);
        }

        //Crocodile Input
        System.out.println("Enter the number of Crocodiles");
        int c = sc.nextInt();
        Crocodile crocodiles = new Crocodile(c);
        List<Integer> crocodileTrack = new ArrayList<>();
        for(int a=0;a<c;a++){
            int value = sc.nextInt();
            crocodileTrack.add(value);
        }
        crocodiles.setCrocodileTrack(crocodileTrack);

        //Mine Input
        System.out.println("Enter the number of Mine points");
        int m = sc.nextInt();
        Mine mines = new Mine(m);
        List<Integer> minePoints = new ArrayList<>();
        for(int b=0;b<m;b++){
            int value = sc.nextInt();
            minePoints.add(value);
        }
        mines.setMinePoints(minePoints);


        System.out.println("Manual Override: Y/N");

        BoardGame game = new BoardGame(snake,ladder,crocodiles,mines);
        PlayGame play = new PlayGame(n,playerMap,game);
        String override = sc.next();
        if(override.equals("Y")) {
            System.out.println("Type anything to continue and Exit to stop the test and continue simulation");
            String continueTest = sc.next();
            while (!continueTest.equals("Exit")) {

                for (int i = 0; i < n; i++) {
                    System.out.println("Enter the "+i+1+" player dice value");
                    int diesValue = sc.nextInt();
                    play.testGame(i, diesValue, playerMap);
                }
                System.out.println("Type anything to continue and Exit to stop the test and continue simulation");
                continueTest = sc.next();
            }

        }
        play.playGame(n,playerMap);

    }

}
