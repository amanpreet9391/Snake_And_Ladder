package SnakeAndLadder;

import java.util.Map;
import java.util.HashMap;

import static SnakeAndLadder.Ladder.isLadderPresent;

public class Snake {
    static Map<Integer,Integer> snakeTrack;
    int numberOfSnakes;


    public Snake(int s){
        this.snakeTrack = new HashMap<>();
        this.numberOfSnakes = s;

    }

    public static int isSnakePresent(Map<Integer,Integer> ladders,int position){
        int newPosition = position;
        if(snakeTrack.containsKey(position)){
            System.out.println("Oops there is a snake!!! "+position);
            newPosition = snakeTrack.get(position);
        }
//        newPosition = isLadderPresent(ladders,newPosition);
        return newPosition;
    }


}
