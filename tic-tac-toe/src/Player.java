public class Player {
    private final String name;
    private Symbol symbol;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }

}
