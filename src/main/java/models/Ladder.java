package models;

import SnakeAndLadder.Snake;

import java.util.HashMap;
import java.util.Map;

public class Ladder {

    int numberOfLadders;
    public static Map<Integer,Integer> ladders;

    public Ladder(int l){
        this.numberOfLadders = l;
        ladders = new HashMap<>();

    }

    public static int isLadderPresent(int position){
        int newPosition = position;
        if(getLadders().containsKey(position)){
            System.out.println("Wohoooo Up and Up I gooo "+position);
            newPosition = getLadders().get(position);
        }
        return newPosition;
    }

    public static void setLadders(Map<Integer, Integer> ladders) {
        Ladder.ladders = ladders;
    }

    public static Map<Integer, Integer> getLadders() {
        return ladders;
    }
}
