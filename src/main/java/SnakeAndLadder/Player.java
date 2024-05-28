package SnakeAndLadder;

public class Player {

    String name;
    int position;
    public int mineSkipCount;

    public Player(String name, int position){
        this.name = name;
        this.position = position;
        this.mineSkipCount = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setMineSkipCount(int mineSkipCount) {
        this.mineSkipCount = mineSkipCount;
    }
}
