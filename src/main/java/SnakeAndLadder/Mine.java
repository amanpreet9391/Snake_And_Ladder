package SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class Mine {

    static List<Integer> minePoints;

    public Mine(){
        minePoints = new ArrayList<>();
    }
    public static Player isMinePresent(List<Integer> minePoints, int position, Player player){
        for(int i=0;i<minePoints.size();i++){
            if(minePoints.get(i) == position){
                System.out.println("Found a mine!!!!!");
                player.setMineSkipCount(2);
            }
        }
        return player;
    }
}
