package com.scottlinenberger.minesweeper.grid;

import java.util.ArrayList;
import java.util.List;

import com.scottlinenberger.minesweeper.cells.CellCoordinates;

public class GridUtils {
  public static List<CellCoordinates> getConnectingCellCoordinates(int row, int column) {
    List<CellCoordinates> listCoordinates = new ArrayList<>();
    
    int[][] arrayValues = new int[][] {
        /* cell above */
        { row - 1, column },
        /* cell below */
        { row + 1, column },
        /* cell left */
        { row, column - 1 },
        /* cell right */
        { row, column + 1 },
        /* top-left */
        { row - 1, column - 1 },
        /* top-right */
        { row - 1, column + 1 },
        /* bottom-left */
        { row + 1, column - 1 },
        /* bottom-right */
        { row + 1, column + 1 } };
        
     for (int[] currentValue : arrayValues) {
       int currRow = currentValue[0];
       int currCol = currentValue[1];
       
       listCoordinates.add(new CellCoordinates(currRow, currCol));
     }
     
     return listCoordinates;
  };
  
  public static boolean isInBounds(MinesweeperGrid grid, int row, int column) {
    int height = grid.getHeight();
    int width = grid.getWidth();
    
    /* check row values */
    if (row < 0 || column < 0) {
      return false;
    }

    if (row > (height - 1) || column > (width - 1)) {
      return false;
    }

    return true;
  }
}
