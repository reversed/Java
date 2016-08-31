import java.util.ArrayList;

public class GameManager
{
    void processTurn(PlayerBase player) { };
    boolean acceptTurn(ChessPieceTurn turn) { return true; }
    Position currentPosition;
}

class ChessPieceTurn { };

abstract class PlayerBase
{
    public abstract ChessPieceTurn getTurn(Position p);
}

class ComputerPlayer extends PlayerBase
{
    public ChessPieceTurn getTurn(Position p) { return null; }
    public void setDifficulty() { };
    public PositionEstimator estimater;
    public PositionBackTracker backtracter;
}

class HumanPlayer extends PlayerBase
{
    public ChessPieceTurn getTurn(Position p) { return null; }
}

abstract class ChessPieceBase
{
    abstract boolean canBeChecked();
    abstract boolean isSupportCastle();
}

class King extends ChessPieceBase
{
    boolean canBeChecked() { return true; }
    boolean isSupportCastle() { return true; }
    // ...
}

class Queen extends ChessPieceBase
{
    boolean canBeChecked() { return true; }
    boolean isSupportCastle() { return true; }
    // ...
}

class Position
{
    ArrayList<ChessPieceBase> black;
    ArrayList<ChessPieceBase> white;
}

class PositionBackTracker
{
    public static Position getNext(Position p) { return null; }
}

class PositionEstimator
{
    public static PositionPotentialValue estimate(Position p) { return null; }
}

abstract class PositionPotentialValue
{
    abstract boolean lessThan(PositionPotentialValue pv);
}

