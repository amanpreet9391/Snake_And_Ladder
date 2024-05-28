package models;

import java.util.List;
import java.util.Map;

public class BoardGame {
    Snake snakes;
    Ladder ladders;
    Crocodile crocodiles;
    Mine mines;

    public BoardGame(Snake snakes,Ladder ladders,Crocodile crocodiles,Mine mines){
        this.snakes = snakes;
        this.ladders = ladders;
        this.crocodiles = crocodiles;
        this.mines = mines;
    }

    public Map<Integer, Integer> getSnakes() {
        return Snake.getSnakeTrack();
    }

    public List<Integer> getCrocodiles() {
        return Crocodile.getCrocodileTrack();
    }

    public Map<Integer, Integer> getLadders() {
        return Ladder.getLadders();
    }

    public List<Integer> getMines() {
        return Mine.getMinePoints();
    }
}
