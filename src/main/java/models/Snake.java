package models;

import java.util.HashMap;
import java.util.Map;

public class Snake {
    public static Map<Integer,Integer> snakeTrack;
    int numberOfSnakes;


    public Snake(int s){
        this.snakeTrack = new HashMap<>();
        this.numberOfSnakes = s;

    }

    public static int isSnakePresent(int position){
        int newPosition = position;
        if(getSnakeTrack().containsKey(position)){
            System.out.println("Oops there is a snake!!! "+position);
            newPosition = getSnakeTrack().get(position);
        }
        return newPosition;
    }

    public static void setSnakeTrack(Map<Integer, Integer> snakeTrack) {
        Snake.snakeTrack = snakeTrack;
    }

    public static Map<Integer, Integer> getSnakeTrack() {
        return snakeTrack;
    }
}
