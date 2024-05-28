package SnakeAndLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crocodile {
    int numberOfCrocodiles;
    static List<Integer> crocodileTrack;

    public Crocodile(int c){
        this.numberOfCrocodiles = c;
        crocodileTrack = new ArrayList<>();
    }
    public static int isCrocodilePresent(List<Integer> crocodileTrack, int position){
        for(int i=0;i<crocodileTrack.size();i++){
            if(crocodileTrack.get(i) == position){
                System.out.println("Crocodile !!!!!!!");
                if(position<=5){
                    return 1;
                }
                else{
                    position = position - 5;
                    return position;
                }
            }
        }
        return position;
    }
}
