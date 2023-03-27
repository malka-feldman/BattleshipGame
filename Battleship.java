/**
 * @author malka
 * 1/4/2021
 *	Battleship Game
 */
package arraymethod;
public class Battleship {
	private boolean[][] grid;
	private char[][] notes;
	
	public Battleship() {
		grid = new boolean[10][10];
		notes = new char[10][10];
	}

	/**
	 * prints a line of dashes
	 */
	private void printLine() {
		for (int i = 0; i <= 15; i++) {
			System.out.print("__");
		}
		System.out.println();
	}

	/**
	 * prints a row of the grid s.t.
	 * 
	 * @param row
	 */
	private void printRow(boolean[] row) {
		for (int i = 0; i<10; i++) {
			System.out.print(" |");
			if (row[i]) {
				System.out.print("*");
			} else {
				System.out.print(" ");
			}
		}
		System.out.println("|");
	}
	/**
	 * prints a row of numbers 1-10
	 * @param row
	 */
	private void printRow(char[] row) {
		for (int i = 0; i<10; i++) {
			System.out.print(" |");
			if (row[i]==0) {
				System.out.print(" ");
			} else {
				System.out.print(row[i]);
			}
		}
		System.out.println("|");
	}
	
	//space on board? x, y boolean method do i have enough board space(size, x, y) 
	public boolean space(int x, int y, int size) {
		if(x+size<10) {
			return true;
		}
		else {
			return false;
		}	
	}
	//check if there is a ship if returns true then false
	public boolean isFree(int x, int y, int size) {
		for(int i=x; i<=x+size; i++) {
			if(grid[x][y]) {
				return false;
			}
		}
		return true;
	}
	
		/**if x>0 then u check above
		if x<9 then u check below
		if y>0 then check left
		if y+size <9 then check right y
		check just directly on top
		*/
	public boolean rules(int x, int y, int size) {
		//if the row on top is not free
			if(x>0) {
				if(!isFree(x-1, y, size)){
					return false;
				}
			}
		//checking below
			if(x<9 && !isFree(x+1, y, size)){
				return false;
			}
		//checking left of it
			if(y>0 && !isFree(x, y-1, 1)){
				return false;
			}
		//checking right of it
			if(y+size<9 && !isFree(x, y+size, 1)){
				return false;
			}	
		return true;
	}
	/**
	 * places ship
	 * @param size
	 */
	private void place(int size){
		int x = (int)(Math.random()*10);
		int y = (int)(Math.random()*10);
		while(!space(x, y, size) || !isFree(x, y, size) || !rules(x, y, size)) {
			x = (int)(Math.random()*10);
			y = (int)(Math.random()*10);
		}
		placeShip(x, y, size);
	}
	
	//method placeShip(int size, int r, int c) that will place a ship of size size at position (r, c).
	private void placeShip(int x, int y, int size) {
		for(int i=0; i<size; i++) {
			grid[x][y+i]=true;
		}
	}
	/**
	 * method that populates the board using the place accessor method
	 * @param level
	 */
	public void populate(int level) {
		for(int i=1; i<=level; i++) {
			for(int j=4-i; j>=0; j--) {
			place(i);
			}
		}
	}
	/*
	 * This method takes the rowLAbel and column that was inputed by the user and returns an x if its a hit and a y if its a miss
	*/
	
	public boolean hit(char rowLabel, int column) {
		int rowNumber=0;
	    rowNumber= (rowLabel-65);
		column = column-1;
		if(grid[rowNumber][column]) {
			notes[rowNumber][column]='x';
		}
		else {
			notes[rowNumber][column]='-';
		}
		return grid[rowNumber][column];
	}
	
	
	/*
	 * This method displays the board for the player to use as a guide it doesnt show where the ships are only the x, and -
	 */
	public void displayNotes() {
		char rowL = 'A';
		for(int i=0; i<10; i++){
			printLine();
			System.out.print((char)(rowL + i));
			printRow(notes[i]);
		}
		System.out.print("   " + 1 + "  ");
		System.out.print(2 + "  ");
		System.out.print(3 + "  ");
		System.out.print(4 + "  ");
		System.out.print(5 + "  ");
		System.out.print(6 + "  ");
		System.out.print(7 + "  ");
		System.out.print(8 + "  ");
		System.out.print(9 + "  ");
		System.out.print(10 + "  ");
		System.out.println();
	}
  /**
   * THis method displays the entire board with the ships
   */
	public void display(){
		char rowL = 'A';
		for(int i=0; i<10; i++){
			printLine();
			System.out.print((char)(rowL + i));
			printRow(grid[i]);
		}
		System.out.print("   " + 1 + "  ");
		System.out.print(2 + "  ");
		System.out.print(3 + "  ");
		System.out.print(4 + "  ");
		System.out.print(5 + "  ");
		System.out.print(6 + "  ");
		System.out.print(7 + "  ");
		System.out.print(8 + "  ");
		System.out.print(9 + "  ");
		System.out.print(10 + "  ");
		System.out.println();
	}
}
