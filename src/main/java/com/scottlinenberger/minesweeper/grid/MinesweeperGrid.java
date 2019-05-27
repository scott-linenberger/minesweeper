package com.scottlinenberger.minesweeper.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.scottlinenberger.minesweeper.cells.CellCoordinates;
import com.scottlinenberger.minesweeper.cells.MinesweeperCell;
import com.scottlinenberger.minesweeper.constants.CellStatus;

public class MinesweeperGrid {
  /* grid dimensions */
  private int height;
  private int width;

  /* cells */
  private MinesweeperCell arrayCells[][];

  public MinesweeperGrid(int width, int height) {
    /* set instance variables */
    this.height = height;
    this.width = width;

    initGrid();
  }

  private void initGrid() {
    /* init the items array */
    arrayCells = new MinesweeperCell[height][width];

    /* populate the array with cells */
    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        arrayCells[row][column] = new MinesweeperCell(row, column);
      }
    }
  }

  public MinesweeperCell getCellAtCoordinates(CellCoordinates coordinates) {
    int row = coordinates.getRow();
    int column = coordinates.getColumn();

    /* return null if the cell isn't in range */
    if (!GridUtils.isInBounds(this, row, column)) {
      return null;
    }

    return arrayCells[row][column];
  }

  public void updateGridCounts() {
    /* loop each cell and calculate mine counts */
    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        /* init a mine count */
        int mineCount = 0;
        
        /* get the current cell */
        MinesweeperCell cell = getCell(row, column);
        
        /* find the cell's connecting cells */
        List<MinesweeperCell> connectingCells = getConnectingCells(cell);
        
        /* loop the connecting cells counting mines */
        for(MinesweeperCell currentCell : connectingCells) {
          if (currentCell.hasMine()) {
            mineCount++;
          }
        }
        
        /* update the cell's mine count */
        cell.setValueTouching(mineCount);
      }
    }
  }

  public void sweepCell(int row, int column) {
    GridSweeper.sweepCell(row, column, this);
  }

  public void sweepCellNumber(int row, int column) {
    MinesweeperCell cell = arrayCells[row][column];
    cell.setStatus(CellStatus.SWEPT_TOUCHING);
    cell.setValueTouching(2);
  }

  public void setMine(int row, int column) {
    cellAt(row, column).setHasBomb(true);
  }

  private MinesweeperCell cellAt(int row, int column) {
    return arrayCells[row][column];
  }

  public MinesweeperCell getCell(int row, int column) {
    if (!GridUtils.isInBounds(this, row, column)) {
      /* cell is out of bounds */
      return null;
    }

    return arrayCells[row][column];
  }

  public List<MinesweeperCell> getConnectingCells(MinesweeperCell cell) {
    List<MinesweeperCell> listCells = new ArrayList<>();

    if (cell == null) {
      return listCells;
    }

    listCells = 
    cell
        .getCoordinatesTouchingCells()
        .stream()
        /* filter off coordinates that aren't in bounds */
        .filter(coordinates -> {
          int row = coordinates.getRow();
          int col = coordinates.getColumn();

          return GridUtils.isInBounds(this, row, col);
        })
        /* map coordinates to cells */
        .map(coordinates -> {
          int row = coordinates.getRow();
          int col = coordinates.getColumn();
          
          return getCell(row, col);
        })
        .collect(Collectors.toList());

    return listCells;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }
}
