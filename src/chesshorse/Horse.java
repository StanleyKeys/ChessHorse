/*
 * Собственно сам "конь", который "ходит" по ячейкам (Cell) доски (GameBoard)
*  в goJump реализуется стратегия основанная на анализе игровых весов ячейки на доске (вычисляются при 
*  создании доски)
 */
package chesshorse;

public class Horse {
    private int tekPosRow;
    private int tekPosColmn;
    private final int dotsJump [] = new int[8];
     public Horse(Cell beginCell) {
        tekPosRow = beginCell.getRow();
        tekPosColmn = beginCell.getColmn();
        beginCell.setUseTrue();
    }
     
     public boolean goJump(GameBoard brd) {
         int min, n;
         int rw, cl;
         int size;
         size = brd.SIZE_BRD;
         int indexMin;
         indexMin = -1;   
         boolean flagEnd;    
         flagEnd = true;         
         
         for(n=0; n < 8; n++) {
             dotsJump [n] = 11;
         }
         rw = tekPosRow - 1;
         cl = tekPosColmn - 2;
         if(detectBoundsBoard(rw, size) && detectBoundsBoard(cl, size)) {
             if(!brd.getCell(rw, cl).getUse())
                dotsJump[0] = brd.getCell(rw, cl).getIgrWes();
         }
         
         rw = tekPosRow - 2;
         cl = tekPosColmn - 1;
         if(detectBoundsBoard(rw, size) && detectBoundsBoard(cl, size)) {
             if(!brd.getCell(rw, cl).getUse())
                dotsJump[1] = brd.getCell(rw, cl).getIgrWes();
         }
         
         rw = tekPosRow - 2;
         cl = tekPosColmn + 1;
         if(detectBoundsBoard(rw, size) && detectBoundsBoard(cl, size)) {
             if(!brd.getCell(rw, cl).getUse())
                dotsJump[2] = brd.getCell(rw, cl).getIgrWes();
         }
         
         rw = tekPosRow - 1;
         cl = tekPosColmn + 2;
         if(detectBoundsBoard(rw, size) && detectBoundsBoard(cl, size)) {
             if(!brd.getCell(rw, cl).getUse())
                dotsJump[3] = brd.getCell(rw, cl).getIgrWes();
         }
         
         rw = tekPosRow + 1;
         cl = tekPosColmn + 2;
         if(detectBoundsBoard(rw, size) && detectBoundsBoard(cl, size)) {
             if(!brd.getCell(rw, cl).getUse())
                dotsJump[4] = brd.getCell(rw, cl).getIgrWes();
         }
         
         rw = tekPosRow + 2;
         cl = tekPosColmn + 1;
         if(detectBoundsBoard(rw, size) && detectBoundsBoard(cl, size)) {
             if(!brd.getCell(rw, cl).getUse())
                dotsJump[5] = brd.getCell(rw, cl).getIgrWes();
         }
         
          rw = tekPosRow + 2;
         cl = tekPosColmn - 1;
         if(detectBoundsBoard(rw, size) && detectBoundsBoard(cl, size)) {
             if(!brd.getCell(rw, cl).getUse())
                dotsJump[6] = brd.getCell(rw, cl).getIgrWes();
         }
         
         rw = tekPosRow + 1;
         cl = tekPosColmn - 2;
         if(detectBoundsBoard(rw, size) && detectBoundsBoard(cl, size)) {
             if(!brd.getCell(rw, cl).getUse())
                dotsJump[7] = brd.getCell(rw, cl).getIgrWes();
         }

         min = 11;   
         for(n=0; n < 8; n++) {
             if(min > dotsJump [n]) {
                 min = dotsJump [n];
                 flagEnd = false;
             }
         }
      
         if(flagEnd) { 
             return false;
         }
         
         for(n=0; n < 8; n++) {
             if(min == dotsJump [n]) {
                 indexMin = n;
                 break;
             }
         }
         
         switch(indexMin) {
             case 0: {
                 tekPosRow += - 1;
                 tekPosColmn +=  - 2;
                 break;
             }
             case 1: {
                 tekPosRow += - 2;
                 tekPosColmn +=  - 1;
                 break;
             }
             case 2: {
                 tekPosRow += - 2;
                 tekPosColmn += 1;
                 break;
             }
             case 3: {
                 tekPosRow += - 1;
                 tekPosColmn += 2;
                 break;
             }
             case 4: {
                 tekPosRow +=  1;
                 tekPosColmn += 2;
                 break;
             }
             case 5: {
                 tekPosRow += 2;
                 tekPosColmn += 1;
                 break;
             }
             case 6: {
                 tekPosRow += 2;
                 tekPosColmn +=  - 1;
                 break;
             }
             case 7: {
                 tekPosRow += 1;
                 tekPosColmn +=  - 2;
                 break;
             }
         }
        brd.getCell(tekPosRow, tekPosColmn).setUseTrue();
        return true;      
     }
     boolean detectBoundsBoard(int rowColmnPos, int sizeBrd) {
         return !((rowColmnPos < 0) || (rowColmnPos > sizeBrd -1));
     }
}
