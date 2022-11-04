/*
 * Описывает ячейки игровой доски
 */
package chesshorse;

public class Cell {
    private final int ROW;
    private final int COLMN;
    private int igrWes;
    private boolean use = false;
    public Cell() {
        this.ROW = 0;
        this.COLMN = 0;
    }
    Cell(int initRow, int initColmn) {
        ROW = initRow;
        COLMN = initColmn;
    }
    void setUseTrue() {
        use = true;
    }
    
    void setUseFalse() {
        use = false;
    }
    
    boolean getUse() {
        return use;
    }
    
    void showCellProp() {
        if(use) {
            System.out.print(" H " +  " | ");
        }
        else {
            System.out.print(ROW + "," + COLMN  + " | ");
        }
    }
   int getRow() {
        return ROW;
    }
    int getColmn() {
        return COLMN;
    }
    
    void setIgrWes(int wes) {
        igrWes = wes;
    }
    int getIgrWes() {
        return igrWes;
    }
    
}
