package com.scottlinenberger.minesweeper.io;

import com.scottlinenberger.minesweeper.cells.MinesweeperCell;
import com.scottlinenberger.minesweeper.grid.MinesweeperGrid;

public abstract class GridPrinter {

  public static void printGrid(MinesweeperGrid grid) {
    System.out.println();
    
    int width = grid.getWidth();
    int height = grid.getHeight();

    printColumnHeadings(width);
    
    StringBuilder output = new StringBuilder();

    for (int row = 0; row < height; row++) {
      output = new StringBuilder();

      /* add the row information */
      output.append(row + "| ");

      for (int column = 0; column < width; column++) {
        MinesweeperCell cell = grid.getCell(row, column);
        output.append(" " + cell.toString() + " ");
      }
      /* print the row */
      System.out.println(output.toString());
    }

  }

  private static void printColumnHeadings(int width) {
    StringBuilder output = new StringBuilder();

    String padding = "    ";

    /* pad the column headers */
    output.append(padding);

    /* print the column headers */
    for (int i = 0; i < width; i++) {
      output.append(i + "  ");
    }

    System.out.println(output.toString());

    output = new StringBuilder();

    int leftPadding = 3;
    
    /* print the horizontal break */
    for (int i = 0; i < (width * 3) + leftPadding; i++) {
      output.append("-");
    }

    System.out.println(output.toString());
  }

}
