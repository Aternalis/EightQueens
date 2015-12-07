
/**
 * 
 * This is the skeleton for the ChessBoard used by the EightQueens program
 * It contains the methods called in the program, as well as a few other methods
 * that I used for testing, and decided they were useful if I wanted to change something
 * 
 */
public class ChessBoard
{   
    public int nByN = 8;
    public String[][] board;
    
    /**default constructor
    */
    public ChessBoard()
    {
        board = new String[8][8];
        for (int i=0; i<8; i++)
            for (int j=0; j<8; j++)
                board[i][j]=" ";
    }
    
    /**constructor given the NxN dimension
     */
    public ChessBoard(int dimension)
    {
        nByN= dimension;
        board = new String[nByN][nByN];
        for (int i=0; i<nByN; i++)
            for (int j=0; j<nByN; j++)
                board[i][j]=" ";
    }
    
    /**returns true if a piece can be placed
     */
    public boolean canPlace(int m, int n)
    {
        if (board[m][n]!="0")
            return false;
        else
            return true;
    }
    
    /**calls the private placeQueen method
     */
    public void placeQueen(int m, int n)
    {
        placeQueen(m,n,'a'); //extra char 'a' to distinguish public and private
    }
    
    /**
    *places a queen (if possible) and marks the spaces she
    *takes up with "X"
    */
    private void placeQueen(int m, int n,char a) //char 'a' to distinguish public and private
    {
        if (queenAmount()!=nByN)
        {
            if (m>=0 && n>=0 && m<nByN && n<nByN)
            {
                if (board[m][n]!="X")
                {
                    for (int i=0;i<nByN;i++)
                    {
                        for (int j=0;j<nByN;j++)
                        {
                            if (i==m || n==j ) //if the same row of column
                                board[i][j]="X";
                            else if (m-i==n-j) // if the upper right or lower left diagonal
                                board[i][j]="X";
                            else if (m-i==j-n) // if the lower right or upper left diagonal
                                board[i][j]="X";
                        }
                    }
                    board[m][n]="Q";
                }
            }
        }
        
    }
    
    /**returns the amount of taken spces given a number from 0-63
     * The board can be thought of as the rows are the integer values,
     * and the columns are the residues
     */
    public int takenSpaces (int m)
    {
        return takenSpaces(m/nByN, m%nByN);
    }
    
    /**returns the amount of taken spaces given a coordinate
     */
    public int takenSpaces (int m, int n)
    {
        char[] spots = new char[nByN*nByN];
        int counter=0;
        
        if (board[m][n]!="X" && board[m][n]!="Q")
        {
            for (int i=0;i<nByN;i++)
            {
                for (int j=0;j<nByN;j++)
                {
                    if (board[i][j]!="X")
                    {
                        // if there is an 'x' in the same row or column
                        if (i==m || n==j )
                            counter++;
                            
                        //if there is an 'x' in either diagonal:
                        else if (m-i==n-j) // if there i
                            counter++;
                        else if (m-i==j-n)
                            counter++;
                    }
                }
            }
        }
        
        return counter;
    }
    
    /**returns the number of queens on the board
     */
    public int queenAmount()
    {
        int number=0;
        
        for (int i=0;i<nByN;i++)
            for (int j=0;j<nByN;j++)
                if (board[i][j]=="Q") //if there's a queen there...
                    number++;
                    
        return number;
    }
    
    /**returns true if the entire board is empty
     */
    public boolean isEmpty()
    {
        int count=0;
        for (int i=0; i<nByN; i++)
            for (int j=0;j<nByN;j++)
                if (board[i][j]!=" ") //if the board space is empty
                    count++;
                    
        if (count==(nByN*nByN))
            return true;
        
        return false;
    }
    
    /**displays the board
     */
    public void display()
    {
        for (int i=0;i<nByN;i++)
        {
            for(int j=0;j<nByN;j++)
            {
                if (board[i][j]=="X")
                    System.out.print("[ ]");
                else
                    System.out.print("["+board[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    /**clears the board
     */
    public void reset()
    {
        for (int i=0; i<nByN; i++)
            for (int j=0; j<nByN; j++)
                board[i][j]=" ";
    }
    
    /**exactly copies one board onto another
     */
    public void copy(ChessBoard pseudo)
    {
        for (int i=0; i<nByN; i++)
            for (int j=0;j<nByN;j++)
                this.board[i][j]=pseudo.board[i][j];
    }
    
    /** Sets a space on the board to a given value
     */
    public void setSpace(int m, int n, String a)
    {
        board[m][n]=a;
    }
    
    /** returns what is on the board at that space
     */
    public String getSpace(int m, int n)
    {
        return board[m][n];
    }
    
    /** displays the ChessBoard with the coordinates in the spots from A1-H8
     */
    public void letterBoard()
    {
        for (int i=0;i<nByN;i++)
            for (int j=0;j<nByN;j++)
                board[i][j]=""+(char)(j+97)+(nByN-i);
        display();
    }
    
    /** displays the ChessBoard with the coordinates in the spots from 00-88
     */
    public void coordinateBoard()
    {
        for (int i=0;i<nByN;i++)
            for (int j=0;j<nByN;j++)
                board[i][j]=""+(i+1)+" "+(j+1)+"";
        display();
    }
}
