package com.scottlinenberger.minesweeper.cells;

public class CellCoordinates {
  private int row;
  private int column;

  public CellCoordinates(int x, int y) {
    this.row = y;
    this.column = x;
  }
  
  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

}
