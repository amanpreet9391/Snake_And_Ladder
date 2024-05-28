package SnakeAndLadder;

import java.util.Map;
import java.util.HashMap;

import static SnakeAndLadder.Snake.isSnakePresent;

public class Ladder {

    int numberOfLadders;
    static Map<Integer,Integer> ladders;
    Snake snake;

    public Ladder(int l){
        this.numberOfLadders = l;
        ladders = new HashMap<>();

    }

    public static int isLadderPresent(Map<Integer,Integer> snakeTrack,int position){
        int newPosition = position;
        if(ladders.containsKey(position)){
            System.out.println("Wohoooo Up and Up I gooo "+position);
            newPosition = ladders.get(position);
        }
//        newPosition = isSnakePresent(snakeTrack,newPosition);
        return newPosition;
    }
}
