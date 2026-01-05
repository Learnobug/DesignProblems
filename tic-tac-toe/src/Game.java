public class Game {
    Player player1 = null;
    Player player2 = null;
    int id;
    GameState state;
    Board board;
    int turnCount;

    Game(){
        this.id = (int)(Math.random() * 10000);
    }

    int getId(){
        return this.id;
    }

    void startGame(){
        if(this.player1 == null || this.player2 == null){
            System.out.println("Cannot start game without two players.");
            return;
        }
        this.state = GameState.STARTED;
        this.board = new Board();
    }

    void addPlayer(Player player){
        if(this.player1 == null){
            this.player1 = player;
            this.state = GameState.WAITING_FOR_PLAYER;
            setSymbol(player1);
        } else if(this.player2 == null){
            this.player2 = player;
            setSymbol(player2);
            startGame();
        } else {
            throw new IllegalStateException("Game is already full.");
        }
    }

    Symbol getCurrentSymbol(){
        if(turnCount % 2 == 0){
            return Symbol.X;
        } else {
            return Symbol.O;
        }
    }

    boolean validturn(Player p){
        if(turnCount % 2 == 0 && p.getSymbol() != Symbol.X){
            return false;
        } else if(turnCount % 2 != 0 && p.getSymbol() != Symbol.O){
            return false;
        }
        return true;
    }

    void setSymbol(Player player){
        if(turnCount % 2 == 0){
            player.setSymbol(Symbol.X);
        } else {
            player.setSymbol(Symbol.O);
        }
        turnCount++;
    }
    void makeMove(Player player, int row,int col){
        if(this.state != GameState.STARTED){
            System.out.println("Game is not started.");
            return;
        }
        if(board.valid(row, col)){
            if(!validturn(player)){
                System.out.println("It's not your turn.");
                return;
            }
            board.set(row, col, player.getSymbol());
            turnCount++;
            if(board.iswinner(player.getSymbol())){
                this.state = GameState.END_GAME;
            } else if(board.isFull()){
                this.state = GameState.END_GAME;
            }
            printgamestate();
        } else {
            throw new IllegalArgumentException("Invalid move.");
        }
    }

    void printturn(){
        if(turnCount % 2 == 0){
            System.out.println("Next Player turn (X)");
        } else {
            System.out.println("Next Player turn (O)");
        }
    }

    void printgamestate(){
        if(board.isFull() && !board.iswinner(Symbol.X) && !board.iswinner(Symbol.O)){
            System.out.println("It's a draw!");
        } else if(board.iswinner(Symbol.X)){
            System.out.println("Player X wins!");
        } else if(board.iswinner(Symbol.O)){
            System.out.println("Player O wins!");
        }else {
            printturn();
        }
    }


}
