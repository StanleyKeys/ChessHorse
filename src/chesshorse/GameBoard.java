/*
 * Игральная доска, состоит из двумерного массива, заполненного объектами типа Cell
 */
package chesshorse;
     
public class GameBoard {
        Cell board[][];
        final int  SIZE_BRD;
    GameBoard(int sizeBoard) {
        board = new Cell[sizeBoard][sizeBoard];
        SIZE_BRD = sizeBoard;
        
        for(int i=0; i < sizeBoard; i++)      {
            for(int j=0; j < sizeBoard; j++) {
                board[i][j] = new Cell(i,j);
            }
        }
        setIgrWes();
    }
    final void setIgrWes() {
        int tmpWes = 0;
       
        for(int i=0; i < SIZE_BRD; i++)      {
            for(int j=0; j < SIZE_BRD; j++) {
                if((i - 2 >= 0) && (j - 1 >= 0)) {
                    if(!getCell(i - 2,j - 1).getUse()) {
                        ++tmpWes;
                    }
                }
                if((i - 2 >= 0) && (j + 1 <= SIZE_BRD - 1)) {
                    if(!getCell(i - 2,j + 1).getUse()) {
                        ++tmpWes;
                    }
                }
                if((i + 2 <= SIZE_BRD - 1) && (j - 1 >= 0)) {
                    if(!getCell(i + 2,j - 1).getUse()) {
                        ++tmpWes;
                    }
                }
                if((i + 2 <= SIZE_BRD - 1) && (j + 1 <= SIZE_BRD - 1)) {
                    if(!getCell(i + 2,j + 1).getUse()) {
                        ++tmpWes;
                    }
                }
                if((i - 1 >= 0) && (j - 2 >= 0)) {
                    if(!getCell(i - 1,j - 2).getUse()) {
                        ++tmpWes;
                    }
                }
                if((i - 1 >= 0) && (j + 2 <= SIZE_BRD - 1)) {
                    if(!getCell(i - 1, j + 2).getUse()) {
                        ++tmpWes;
                    }
                }
                if((i + 1 <= SIZE_BRD - 1) && (j - 2 >= 0)) {
                    if(!getCell(i + 1,j - 2).getUse()) {
                        ++tmpWes;
                    }
                }
                if((i + 1 <= SIZE_BRD - 1) && (j + 2 <= SIZE_BRD - 1)) {
                    if(!getCell(i + 1, j + 2).getUse()) {
                        ++tmpWes;
                    }
                }
                getCell(i, j).setIgrWes(tmpWes);
                tmpWes = 0;
            }
        }
    }
    void printBoard() {
        for(int i=0; i < SIZE_BRD; i++)      {
            for(int j=0; j < SIZE_BRD; j++) {
               board[i][j].showCellProp();
            }
            System.out.println("\n");
        }
    }
    
    Cell getCell(int row, int col) {
        return board[row][col];  
    }
}
