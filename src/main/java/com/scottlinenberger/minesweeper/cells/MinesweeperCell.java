package com.scottlinenberger.minesweeper.cells;

import com.scottlinenberger.minesweeper.constants.CellStatus;
import com.scottlinenberger.minesweeper.constants.DisplayChar;

public class MinesweeperCell extends StandardCell {

  private CellStatus status;
  private int valueTouching = 0;
  private boolean hasMine = false;

  public MinesweeperCell(int coordinateX, int coordinateY) {
    super(coordinateX, coordinateY);
    
    /* default cell status to hidden */
    status = CellStatus.UNSWEPT;
  }

  public CellStatus getStatus() {
    return status;
  }

  public int getValueTouching() {
    return valueTouching;
  }

  public boolean hasMine() {
    return hasMine;
  }

  public boolean isHasBomb() {
    return hasMine;
  }

  public void setHasBomb(boolean hasBomb) {
    this.hasMine = hasBomb;
  }

  public void setStatus(CellStatus status) {
    this.status = status;
  }

  public void setValueTouching(int valueTouching) {
    this.valueTouching = valueTouching;
  }
  
  @Override
  public String toString() {
    switch(status) {
      case SWEPT_EMPTY:
      case UNSWEPT:
      case SWEPT_MINE:
        return status.toString();
      case SWEPT_TOUCHING:
        return String.valueOf(valueTouching);
      default:
        return "D";
    }
  }
}
