package Tests;

import Configuration.ConfigurationFactory;
import SnakeAndLadder.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeAndLadderTests {

    public static Map<Integer, Player> playerMap = new HashMap<>();


    @BeforeEach
    public void setup() {
        ConfigurationFactory.initializeConfiguration();
        BoardGame game = new BoardGame();




    }

    public void addPlayers(){
        Player player1 = new Player("Ap",50);
        Player player2 = new Player("Aj",100);
        playerMap.put(0,player1);
        playerMap.put(1,player2);

    }

    @Test
    public void testNegativeDiesValue() throws InvalidValusForDiesException {
        setup();
        Snake snake = new Snake(2);
        Ladder ladder = new Ladder(3);
        Play play = new Play(snake, ladder);
        try{
            play.testGame(0,-2,playerMap);
        } catch (Exception e){
            assertEquals(InvalidValusForDiesException.class, e.getClass());
        }

    }

    public void takeDummyInputValues(){

    }



//
}
