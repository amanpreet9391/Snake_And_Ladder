package service;


import models.BoardGame;
import models.Player;

import java.util.Map;

import static models.Crocodile.isCrocodilePresent;
import static models.Ladder.isLadderPresent;
import static models.Mine.isMinePresent;
import static models.Snake.isSnakePresent;

public class PlayerMovements {

    int move(int initialPosition, int diesValue, Player player, Map<Integer,Player> playerMap ){
        //Initial value = 1 (10x0+1) 0th row and 1st column.
        int newPosition = initialPosition+diesValue;
        newPosition = isSnakePresent(newPosition);
        newPosition = isLadderPresent(newPosition);
        newPosition = isCrocodilePresent(newPosition);

        player = isMinePresent(newPosition,player);
        ifPositionAlreadyOccupied(newPosition,playerMap);
        return newPosition;
    }

    void ifPositionAlreadyOccupied(int position, Map<Integer,Player> playerMap){
        for(Map.Entry<Integer, Player> map: playerMap.entrySet()){
            Player player = map.getValue();
            if(player.getPosition()==position){
                player.setPosition(1);
            }
        }
    }

}
