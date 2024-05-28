package Configuration;

import lombok.Data;

@Data
public class Configuration {
    private int players;
    private int boardSize;
    private int snakes;
    private int ladders;
    private int crocodiles;
    private int mines;
    private int dies;
    private String ms;
}
