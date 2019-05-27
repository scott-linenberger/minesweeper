package com.scottlinenberger.minesweeper.constants;

public enum CellStatus {
  UNSWEPT(DisplayChar.CELL_UNSWEPT),
  SWEPT_EMPTY(DisplayChar.CELL_SWEPT_EMPTY),
  SWEPT_TOUCHING(null),
  SWEPT_MINE(DisplayChar.CELL_SWEPT_BOMB);
  
  private String displayChar;
  
  CellStatus(String displayChar) {
    this.displayChar = displayChar;
  }
  
  @Override
  public String toString() {
    return displayChar;
  }
}
