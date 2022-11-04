/*
 * 
 * 
 */
package chesshorse;

public class Gogo {
    public static void main(String[] args) {
        GameBoard board = new GameBoard(8);
        Horse konik = new Horse(board.getCell(1, 7));
        int countJump=0;
         while(konik.goJump(board)) {
             countJump++;
         }
        board.printBoard();
        System.out.println(countJump);
    }
    
}
