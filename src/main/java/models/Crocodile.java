package models;

import java.util.ArrayList;
import java.util.List;

public class Crocodile {
    int numberOfCrocodiles;
    static List<Integer> crocodileTrack;

    public Crocodile(int c){
        this.numberOfCrocodiles = c;
        crocodileTrack = new ArrayList<>();
    }
    public static int isCrocodilePresent(int position){
        for(int i=0;i<getCrocodileTrack().size();i++){
            if(getCrocodileTrack().get(i) == position){
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

    public static void setCrocodileTrack(List<Integer> crocodileTrack) {
        Crocodile.crocodileTrack = crocodileTrack;
    }

    public static List<Integer> getCrocodileTrack() {
        return crocodileTrack;
    }
}
