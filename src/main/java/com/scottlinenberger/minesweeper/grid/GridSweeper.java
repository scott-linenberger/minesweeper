package com.scottlinenberger.minesweeper.grid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.scottlinenberger.minesweeper.cells.CellCoordinates;
import com.scottlinenberger.minesweeper.cells.MinesweeperCell;
import com.scottlinenberger.minesweeper.constants.CellStatus;
import com.scottlinenberger.minesweeper.log.Logger;

public class GridSweeper {

  private static final Logger LOGGER = new Logger(GridSweeper.class);

  public static void sweepCell(int row, int column, MinesweeperGrid grid) {
    MinesweeperCell cell = grid.getCell(row, column);

    sweepConnectingCells(
        cell,
        grid,
        new HashSet<>());

    /* if the cell has a mine, it's game over! */
    if (cell.hasMine()) {
      LOGGER.log("HIT A MINE! GAME OVER!");
      System.exit(0);
    }
  }

  private static void sweepConnectingCells(
      MinesweeperCell cell,
      MinesweeperGrid grid,
      Set<MinesweeperCell> setVisitedCells) {

    /* do not revisit cells, return if cell visited */
    if (setVisitedCells.contains(cell)) {
      return;
    }

    /*
     * add the current cell to the visited list to prevent recursive calls from
     * visiting this cell
     */
    setVisitedCells.add(cell);

    /* if the cell has not been visited and doesn't have a mine */
    /* get the coordinates of the connecting cells */
    List<MinesweeperCell> listConnectingCellCoordinates =
        grid.getConnectingCells(cell);
    
    listConnectingCellCoordinates
      .stream()
      /* don't sweep cells with mines */
      .filter(filterCell -> !filterCell.hasMine())
      /* loop through the connecting cells */
      .forEach(currentCell -> {
        CellStatus status = 
            currentCell.getValueTouching() > 0
            ? CellStatus.SWEPT_TOUCHING
            : CellStatus.SWEPT_EMPTY;
            
        currentCell.setStatus(status);    
        
        GridSweeper.sweepConnectingCells(currentCell, grid, setVisitedCells);
      });
  }

}
