package com.scottlinenberger.minesweeper.cells;

public interface Cell {
  int getCoordinateX();
  int getCoordinateY();
  void setCoordinateX(int x);
  void setCoordinateY(int y);
  void setCoordinates(int x, int y);
}
