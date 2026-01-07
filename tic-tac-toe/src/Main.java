//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
   Player player1 = new Player("Alice");
    Player player2 = new Player("Bob");

    GameSystem gameSystem = new GameSystem();
    Game game = gameSystem.createGame(player1);
    gameSystem.joinGame(game.getId(), player2);

    game.startGame();
    game.makeMove(player1, 0, 0);
    game.makeMove(player2, 1, 1);
    game.makeMove(player1, 0, 1);
    game.makeMove(player2, 2, 2);
    game.makeMove(player1, 1, 2);
    game.makeMove(player2,2,1);
    game.makeMove(player1, 1, 0);
    game.makeMove(player2,0,2);
    game.makeMove(player1, 2, 0);

}
