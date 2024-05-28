package SnakeAndLadder;

import Configuration.Configuration;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;

import static Configuration.ConfigurationFactory.configuration;
import static SnakeAndLadder.BoardGame.playerMap;
import static SnakeAndLadder.Crocodile.crocodileTrack;
import static SnakeAndLadder.Crocodile.isCrocodilePresent;
import static SnakeAndLadder.Ladder.isLadderPresent;
import static SnakeAndLadder.Mine.isMinePresent;
import static SnakeAndLadder.Mine.minePoints;
import static SnakeAndLadder.Snake.isSnakePresent;

import Configuration.ConfigurationFactory;
import service.DiceRoll;


public class Play {
    private static final Configuration configuration = ConfigurationFactory.configuration;
    //Players, Number of Dies, Movement Strategy.
    BoardGame boardGame;
    Snake snake;
    Ladder ladder;
    Crocodile crocodile;
    Mine mine;

    public Play(Snake snake, Ladder ladder){
        this.snake = snake;
        this.ladder = ladder;

    }

    public Play(Snake snake, Ladder ladder,Crocodile crocodile, Mine mine){

        this.snake = snake;
        this.ladder = ladder;
        this.crocodile = crocodile;
        this.mine = mine;

    }


    int move(int initialPosition,int diesValue, Player player){
        //Initial value = 1 (10x0+1) 0th row and 1st column.
        int newPosition = initialPosition+diesValue;
        newPosition = isSnakePresent(this.ladder.ladders,newPosition);
        newPosition = isLadderPresent(this.snake.snakeTrack,newPosition);
        newPosition = isCrocodilePresent(crocodileTrack, newPosition);

        player = isMinePresent(minePoints,newPosition,player);
        // value/10 = x value value%10 = y value
        ifPositionAlreadyOccupied(newPosition,playerMap);
        return newPosition;
    }

    void ifPositionAlreadyOccupied(int position,Map<Integer,Player> playerMap){
        for(Map.Entry<Integer,Player> map: playerMap.entrySet()){
            Player player = map.getValue();
            if(player.getPosition()==position){
                player.setPosition(1);
            }
        }
    }

    public String startGame(int n,Map<Integer,Player> playerMap){
        System.out.println("Get Set Go");
        int turn = 0;
        Player player = playerMap.get(turn);
        String playerTurn = player.getName();
        int position = player.getPosition();
        int initialPosition = position;

        while(position<100 && turn<n){

            if(player.mineSkipCount!=0){
                player.mineSkipCount =   player.mineSkipCount-1;
            }
            else{
                System.out.println("Start the game");
                player = playerMap.get(turn);
                playerTurn = player.getName();
                System.out.println(playerTurn+" playerTurn");

                initialPosition = player.getPosition();
                System.out.println(initialPosition+" initialPosition");

                int diesValue = DiceRoll.rollDies(configuration.getDies(),configuration.getMs());
                System.out.println(diesValue+" diesValue");

                position = move(initialPosition,diesValue,player);
                System.out.println(position+" position");

                player.setPosition(position);
//            this.players.players.put(playerTurn,position);
                System.out.println(playerTurn+" rolled a "+diesValue+" and moved from "+initialPosition+" to "+position);

            }
            turn++;
            if(turn == n){
                turn = 0;
            }
        }

    return playerTurn;
    }
    public void testGame(int turn,int diesValue, Map<Integer,Player> playerMap) throws InvalidValusForDiesException {

        try{
            Player player = playerMap.get(turn);
            String playerTurn = player.getName();
            System.out.println(playerTurn+" playerTurn");

            int initialPosition = player.getPosition();
//        int initialPosition = this.players.players.get(playerTurn);
            System.out.println(initialPosition+" initialPosition");
            int position = move(initialPosition,diesValue,player);
            System.out.println(position+" position");

            player.setPosition(position);
        } catch (Exception e){
            if(diesValue<0){
                throw new InvalidValusForDiesException(e.getMessage());
            }
        }

    }




}
