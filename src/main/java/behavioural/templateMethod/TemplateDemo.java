package behavioural.templateMethod;

/*  Template Method - allows us to define the 'skeleton' of the algorithm,
        with concrete implementations defined in subclasses

      1. define an algorithm at a high level
      2. define constituent part as abstract methods/properties
      3. inherit the algorithm class, providing necessary overrides
* */
abstract class Game {
    public int currentPlayer;
    public final int noOfPlayers;

    public Game(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

    public void run() {
        start();
        while(!haveWinner())
            takeTurn();

        System.out.println("Player " + getWinningPlayer() + " wins !");
    }

    protected abstract void start();
    protected abstract boolean haveWinner();
    protected abstract void takeTurn();
    protected abstract int getWinningPlayer();
}

class Chess extends Game {
    private int maxTurns = 10;
    private int turn = 1;

    public Chess() {
        super(2);
    }

    @Override
    protected void start() {
        System.out.println("Starting a game of Chess.");
    }

    @Override
    protected boolean haveWinner() {
        return turn == maxTurns;
    }

    @Override
    protected void takeTurn() {
        System.out.println("Turn " + (turn++) + " taken by player " + currentPlayer);
        currentPlayer = (currentPlayer + 1) % noOfPlayers;
    }

    @Override
    protected int getWinningPlayer() {
        return 0;
    }
}

public class TemplateDemo {
    public static void main(String[] args) {
        new Chess().run();
    }
}
