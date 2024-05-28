package SnakeAndLadder;

import Configuration.Configuration;

import Configuration.ConfigurationFactory;

import java.util.*;

public class BoardGame {
    private static final Configuration configuration = ConfigurationFactory.configuration;
    public static Map<Integer,Player> playerMap = new HashMap<>();

    int[][] board;
//    int boardSize;
    int numberOfPlayers;
    int snakes;
    int ladders;
    int numberOfDies;
    String movementStrategy;

    int crocodiles;
    int mines;

    public BoardGame(){
        //this.boardSize = 10;
        int boardSize = configuration.getBoardSize();
        this.board = new int[boardSize+1][boardSize+1];
        for(int x=0;x<boardSize;x++){

                this.board[x][0] = -1;

        }
        for(int y=0;y<boardSize;y++){

            this.board[10][y] = -1;

        }


    }
//    public String getMovementStrategy(){
//        return this.movementStrategy;
//    }
//    public int getNumberOfDies(){
//        return this.numberOfDies;
//    }

    public void takeInput(Snake snake, Ladder ladder){
        Scanner sc = new Scanner(System.in);

        //Snake Input
        System.out.println("Enter the number of snakes");
        int s = sc.nextInt();
        setSnakes(s);
        for(int i=0;i<s;i++){
            int head = sc.nextInt();
            int tail = sc.nextInt();
            snake.snakeTrack.put(head,tail);
        }
//
//        //Ladder input
        System.out.println("Enter the number of ladders");
        int l = sc.nextInt();
        setLadders(l);
        for(int j=0;j<l;j++){
            int bottom = sc.nextInt();
            int top = sc.nextInt();
            ladder.ladders.put(bottom,top);
        }

        //Player Input
        System.out.println("Enter the number of players");
        int n = sc.nextInt();
        setNumberOfPlayers(n);
        //Players players = new Players(n);
        for(int k=0;k<n;k++){
            String name = sc.next();
            int startingPosition = sc.nextInt();
            Player player = new Player(name,startingPosition);
            playerMap.put(k,player);
//            players.playerNames.add(name);
//            players.players.put(name,startingPosition);
//            System.out.println(players.players.size());
        }

        //Crocodile Track
        System.out.println("Enter the number of Crocodiles");
        int c = sc.nextInt();
        List<Integer> crocodileTrack = new ArrayList<>();
        for(int a=0;a<c;a++){
            int value = sc.nextInt();
            crocodileTrack.add(value);
        }

        //Mine Points
        System.out.println("Enter the number of Mine points");
        int m = sc.nextInt();
        List<Integer> minePoints = new ArrayList<>();
        for(int b=0;b<m;b++){
            int value = sc.nextInt();
            minePoints.add(value);
        }



    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getSnakes() {
        return snakes;
    }

    public int getLadders() {
        return ladders;
    }

    public void setSnakes(int snakes) {
        this.snakes = snakes;
    }

    public void setLadders(int ladders) {
        this.ladders = ladders;
    }

    public static Map<Integer, Player> getPlayerMap() {
        return playerMap;
    }

    public int getCrocodiles() {
        return crocodiles;
    }

    public int getMines() {
        return mines;
    }
}
