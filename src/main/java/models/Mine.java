package models;



import java.util.ArrayList;
import java.util.List;

public class Mine {

    static List<Integer> minePoints;
    int m;

    public Mine(int m){
        minePoints = new ArrayList<>();
        this.m = m;
    }
    public static Player isMinePresent(int position, Player player){
        for(int i=0;i<getMinePoints().size();i++){
            if(getMinePoints().get(i) == position){
                System.out.println("Found a mine!!!!!");
                player.setMineSkipCount(2);
            }
        }
        return player;
    }

    public static void setMinePoints(List<Integer> minePoints) {
        Mine.minePoints = minePoints;
    }

    public static List<Integer> getMinePoints() {
        return minePoints;
    }
}
