import Configuration.ConfigurationFactory;
import SnakeAndLadder.*;
import service.GameStarter;

public class Main {

    public static void main(String[] args) throws InvalidValusForDiesException, service.InvalidValusForDiesException {

//        Scanner sc = new Scanner(System.in);
//        ConfigurationFactory.initializeConfiguration();
//        BoardGame game = new BoardGame();
//        System.out.println(game.getNumberOfPlayers()+" number of players");
//        //Players players = new Players(game.getNumberOfPlayers());
//        Snake snake = new Snake(game.getSnakes());
//        Ladder ladder = new Ladder(game.getLadders());
//        Crocodile crocodile = new Crocodile(game.getCrocodiles());
//        Mine mine = new Mine();
//
//        game.takeInput(snake,ladder);
//        Play play = new Play(snake,ladder,crocodile,mine);
//        System.out.println("Manual Override: Y/N");
//
//        String override = sc.next();
//        if(override.equals("Y")){
//            System.out.println("Type anything to continue and Exit to stop the test and continue simulation");
//            String continueTest = sc.next();
//            while(!continueTest.equals("Exit")){
//
//                for(int i=0;i<game.getNumberOfPlayers();i++){
//                    int diesValue = sc.nextInt();
//                    play.testGame(i,diesValue,playerMap);
//                }
//                System.out.println("Type anything to continue and Exit to stop the test and continue simulation");
//                continueTest = sc.next();
//            }
//
//
//        }
//
//        play.startGame(game.getNumberOfPlayers(),playerMap);
//
        ConfigurationFactory.initializeConfiguration();
        GameStarter.startGame();

    }
}
