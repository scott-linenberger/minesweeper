package com.scottlinenberger.minesweeper.grid;

public class Grid {
  
  private int height;
  private int width;
  
	private Cell[][] arrayCells;

	public Grid(int height, int width) {
	  initGrid();
	}

	private void initGrid() {
		/* init the items array */
		arrayCells = new Cell[height][width];
		
		/* populate the array with cells */
		for (int row = 0; row < height; row++) {
		  for (int column = 0; column < width; column++) {
		    arrayCells[row][column] = new Cell() {};
		  }
		}
	}
	
	public Cell getItemAtCoordinates(int x, int y) {
	  return arrayCells[y][x];
	}

}
