package service;

import Configuration.Configuration;

import java.util.Map;
import Configuration.ConfigurationFactory;
import models.BoardGame;
import models.Player;


public class PlayGame {
    private static final Configuration configuration = ConfigurationFactory.configuration;
    //Players, Number of Dies, Movement Strategy.
    PlayerMovements movements;
    Map<Integer, models.Player> playerMap;
    BoardGame game;
    int n;

    public PlayGame(int n,Map<Integer, models.Player> playerMap,BoardGame game){
        this.n = n;
        this.playerMap = playerMap;
        this.game = game;
        movements = new PlayerMovements();
    }


    public String playGame(int n, Map<Integer, models.Player> playerMap){
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

                initialPosition = player.getPosition();
                int diesValue = DiceRoll.rollDies(configuration.getDies(),configuration.getMs());
                position = movements.move(initialPosition,diesValue,player,playerMap);
                player.setPosition(position);

                System.out.println(playerTurn+" rolled a "+diesValue+" and moved from "+initialPosition+" to "+position);

            }
            turn++;
            if(turn == n){
                turn = 0;
            }
        }

        return playerTurn;
    }
    public void testGame(int turn,int diesValue, Map<Integer, models.Player> playerMap) throws InvalidValusForDiesException {

        try{
            models.Player player = playerMap.get(turn);
            String playerTurn = player.getName();

            int initialPosition = player.getPosition();
            int position = movements.move(initialPosition,diesValue,player,playerMap);

            player.setPosition(position);
        } catch (Exception e){
            if(diesValue<0){
                throw new InvalidValusForDiesException(e.getMessage());
            }
        }

    }

}
