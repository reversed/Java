enum Piece
{
    Empty,
    Red,
    Blue
}

enum Check
{
    Row,
    Column,
    Diagonal,
    ReverseDiagonal
}

public class Board
{
    Piece getIthColor(Piece[][] board, int index, int var, Check check)
    {
        if (check == Check.Row)
        {
            return board[index][var];
        }
        else if (check == Check.Column)
        {
            return board[var][index];
        }
        else if (check == Check.Diagonal)
        {
            return board[var][var];
        }
        else if (check == Check.ReverseDiagonal)
        {
            return board[board.length - 1 - var][var];
        }
        return Piece.Empty;
    }
    
    Piece getWinner(Piece[][] board, int fixed_index, Check check)
    {
        Piece color = getIthColor(board, fixed_index, 0, check);
        if (color == Piece.Empty)
        {
            return Piece.Empty;
        }
        
        for (int var = 1; var < board.length; var++)
        {
            if (color != getIthColor(board, fixed_index, var, check))
            {
                return Piece.Empty;
            }
        }
        return color;
    }
    
    Piece hasWon(Piece[][] board)
    {
        int N = board.length;
        Piece winner = Piece.Empty;
        
        for (int i = 0; i < N; i++)
        {
            winner = getWinner(board, i, Check.Row);
            if (winner != Piece.Empty)
            {
                return winner;
            }
            
            winner = getWinner(board, i, Check.Column);
            if (winner != Piece.Empty)
            {
                return winner;
            }
        }
        
        winner = getWinner(board, -1, Check.Diagonal);
        if (winner != Piece.Empty)
        {
            return winner;
        }
        
        winner = getWinner(board, -1, Check.ReverseDiagonal);
        if (winner != Piece.Empty)
        {
            return winner;
        }
        
        return Piece.Empty;
    }
}








