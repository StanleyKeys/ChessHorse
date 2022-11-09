/*
 * 
 * 
 */
package chesshorse;

import java.util.Scanner;

public class Gogo {
    public static void main(String[] args) {
        System.out.print("Введите размер доски: ");
        Scanner userEnter = new Scanner(System.in);
        int num = userEnter.nextInt();
        GameBoard board = new GameBoard(num);
        Horse plotva = new Horse(board.getCell(1, num-1));
        int countJump=0;
         while(plotva.goJump(board)) {
             countJump++;
         }
        board.printBoard();
        System.out.println("Количество ходов: " + countJump);
        //System.out.println(countJump);
    }
    
}
