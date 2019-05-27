package com.scottlinenberger.minesweeper.io;

import org.junit.Test;

import com.scottlinenberger.minesweeper.grid.MinesweeperGrid;

public class GridPrinterTest {

  @Test
  public void test() {
    MinesweeperGrid grid = new MinesweeperGrid(10, 10);
    
    GridPrinter.printGrid(grid);
    
//    grid.setMine(9, 5);
    grid.setMine(8, 5);
    grid.setMine(7, 5);
    grid.setMine(6, 5);
    grid.setMine(5, 5);
    grid.setMine(4, 5);
    grid.setMine(3, 5);
    grid.setMine(2, 5);
    grid.setMine(1, 5);
    grid.setMine(0, 5);
    
    grid.setMine(2, 0);
    grid.setMine(2, 1);
    grid.setMine(2, 2);
    grid.setMine(1, 2);
    grid.setMine(0, 2);
    
    grid.updateGridCounts();
    
//    grid.sweepCell(4, 2);
    grid.sweepCell(9, 9);
    grid.sweepCell(0, 0);
    
    GridPrinter.printGrid(grid);
  }

}
