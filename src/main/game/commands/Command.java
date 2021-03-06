package game.commands;


import game.gameboard.GameBoard;

/**
 * Command pattern for action invoking
 */
public abstract class Command {

    protected GameBoard gameBoard;         // GameBoard to handle interaction
    protected int duration;                // Time until activation

    public abstract void exec();                  // Basic execute signature for commands

    // Get time until activation
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Iterate activation time
    public void iterateDuration() {
        this.duration--;
    }

}
