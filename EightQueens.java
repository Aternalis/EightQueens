/**
 * The main purpose of this program is, given an initial queen on a chess board,
 * place 7 other queens so that none of the 8 queens can capture another queen in one move
 * This program will read both the chess terms (a1-h8) and the "layman's terms" (1,1-8,8)
 *  
 */

import java.util.*;

public class EightQueens
{
    public static int nByn=8;
    public static ChessBoard board = new ChessBoard(nByn);
    public static int m;
    public static int n;
    public static int count;
    public static int total;
    
    public static void main(String[] args)
    {   
        /**
         * Computing ALL computations for 8x8 takes 26,360,768 computations
         * g1, or (8,7) takes the longest; 2,503,040
         * a3, or (6,1) takes the shortest: 512
         * Average: 411,887
         */
         
        try{
            if (args[0].charAt(0)=='0')
                mutatedChessBoard();
            else if (args[0].length()==1)
            {// these lines read coordings from (1,1) to (8,8)
                m= Integer.parseInt(args[0])-1; //converts the string to a 0-7 int scale for row
                n= Integer.parseInt(args[1])-1; //converts the string to a 0-7 int scale for column
                EightQueens(m,n);
            }
            else
            {
                //these lines are for reading from a chess board; ie, a1-h8
                n=(int)args[0].charAt(0)-97; //converts the character to the column coordinate
                m=((int)args[0].charAt(1)-49-(nByn-1))*(-1); //converts the character to the row coordinate
                //m=((int)args[0].charAt(1)-49-7)*(-1);
                letterEightQueens(m,n);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            board.display();
            System.out.println("That is not a spot on the chessboard.");
            System.out.println("Chessboard locations: ");
            board.letterBoard();
            System.out.println("\nLayman's terms: ");
            board.coordinateBoard();
        }
    }
    
    /**
     * This methods does calculations using a chessboard as if the upper left corner was
     * (0,0) and the lower right corner was (7,7). It then displays the board and the
     * queen locations using standard chessboard identifications.
     */
    public static void letterEightQueens(int a, int b)
    {
        ChessBoard temp = new ChessBoard(nByn);
        temp.copy(board);
        
        if (board.getSpace(a,b)==" ")
        {
            if (board.queenAmount()!=nByn)
            {
                board.placeQueen(a,b); //place queen
                for (int i=0; i<nByn;i++)
                    for (int j=0; j<nByn; j++)
                    {
                        //count++; //for checking total calculations
                        if (board.getSpace(i,j)!=" ")
                            {}//System.out.println( "cannot place queen at ("+i+","+j+")");
                        else
                            letterEightQueens(i,j);
                        }
                if (board.queenAmount()!=nByn)
                    board.copy(temp); //retrace steps to the most previous bord
            }
        }
        
        
        /**
         * The next two sections of code change the integer solutions to the character solution,
         * namely, converts from a (0,0-7,7) scale to an (a1-h8) scale
         */
        if (board.queenAmount()==nByn) //if there are 8 queens on the board
            System.out.println("Queen location: "+(char)(b+97)+(nByn-a));
            
        if (m==a && b==n)
        {
              System.out.println("Initial placement "+(char)(b+97)+(nByn-a));
              //the next line shows the amount of computations the program took to calculate the solution
              //total+=count; 
              board.display();
        }
       
    }
    
    /**
     * This code takes a board input where the upper left is (1,1) and the
     * lower right is (8,8). It then displays the board and gives the queens
     * using those coordinates. The calculations are done as if the 
     * upper left is (0,0) and the lower right is (7,7)
     */
    public static void EightQueens(int a, int b)
    {
        ChessBoard temp = new ChessBoard();
        temp.copy(board);
        
        if (board.getSpace(a,b)==" ")
        {
            if (board.queenAmount()!=8)
            {
                board.placeQueen(a,b); //place queen
                for (int i=0; i<8;i++)
                    for (int j=0; j<8; j++)
                    {
                        //count++; //for checking total calculations
                        if (board.getSpace(i,j)!=" ")
                            {}//System.out.println( "cannot place queen at ("+i+","+j+")");
                        else
                            EightQueens(i,j);
                        }
                if (board.queenAmount()!=8)
                    board.copy(temp); //retrace steps to the most previous bord
            }
        }
        
        /**
         * The next two sections of code change the solutions from a (0,0-7,7) scale to
         * the "Layman's scale" of (1,1-8,8)
         */
        
        if (board.queenAmount()==8)
            System.out.println("Queen location: ("+(a+1)+","+(b+1)+")");
          
        if (m==a && b==n)
        {
              System.out.println("Initial placement ("+(a+1)+","+(b+1)+")");
              //the next line shows the amount of computations the program took to calculate the solution
              //total+=count; 
              board.display();
        }
    }
    
    /**
     * The ComputeAll method runs all possible initial board placements. 
     * This method is not called anywhere, so it must be manually implemented
     */
    
    public static void ComputeAll()
    {
        for (int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++)
            {
                //count=0;
                m=i; n=j;
                EightQueens(m,n);
                count=0;
                board.reset();
            }
        }
    }
    
    public static void mutatedChessBoard()
    {
        Scanner dim = new Scanner(System.in);
        System.out.print("Enter the dimension of the board: ");
        nByn=dim.nextInt();
        board = new ChessBoard(nByn);
        System.out.print("Enter the first queen: ");
        dim.nextLine();
        String dimension = dim.nextLine();
        n=(int)dimension.charAt(0)-97; //converts the character to the column coordinate
        m=((int)dimension.charAt(1)-49-(nByn-1))*(-1); //converts the character to the row coordinate
        if ((int)dimension.charAt(1)>=97)
            m=((int)dimension.charAt(1)-88-(nByn-1))*(-1);
        letterEightQueens(m,n);
    }
}
