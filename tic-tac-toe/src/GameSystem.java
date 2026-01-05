import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameSystem {
    Map<Integer,Game> games = new HashMap<>();
    List<Game> WaitingGames = new ArrayList<>();

    void joinRandomGame(Player player){
        if(WaitingGames.size() == 0){
            Game newGame = new Game();
            newGame.addPlayer(player);
            WaitingGames.add(newGame);
        } else {
            Game game = WaitingGames.get(0);
            game.addPlayer(player);
            WaitingGames.remove(0);
        }
    }

    Game createGame(Player player){
        Game newGame = new Game();
        newGame.addPlayer(player);
        games.put(newGame.getId(), newGame);
        return newGame;
    }

    void joinGame(int gameId, Player player){
        if(games.containsKey(gameId)){
            Game game = games.get(gameId);
            game.addPlayer(player);
            game.startGame();
        } else {
            throw new IllegalArgumentException("Game with ID " + gameId + " does not exist.");
        }
    }

}
