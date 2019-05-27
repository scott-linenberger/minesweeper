package com.scottlinenberger.minesweeper.cells;

import java.util.List;

import com.scottlinenberger.minesweeper.grid.GridUtils;

public class StandardCell implements Cell {

  int coordinateX;
  int coordinateY;
  
  public StandardCell(int coordinateX, int coordinateY) {
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }
  
  @Override
  public int getCoordinateX() {
    return coordinateX;
  }

  @Override
  public int getCoordinateY() {
    return coordinateY;
  }

  @Override
  public void setCoordinateX(int x) {
    coordinateX = x;
  }

  @Override
  public void setCoordinateY(int y) {
    coordinateY = y;
  }

  @Override
  public void setCoordinates(int x, int y) {
    this.coordinateX = x;
    this.coordinateY = y;
  }

  public List<CellCoordinates> getCoordinatesTouchingCells() {
    return GridUtils.getConnectingCellCoordinates(coordinateY, coordinateX);
  }
  
}
