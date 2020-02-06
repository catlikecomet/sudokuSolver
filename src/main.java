import java.util.Arrays;

public class main {

    public static void main (String[] args) {

    }
    //AHHH 2D ARRAYS OMG :(
    public int[][] sudoku = {
            {0,0,0,0,0,2,1,0,0},
            {0,0,4,0,0,8,7,0,0},
            {0,2,0,3,0,0,9,0,0},
            {6,0,2,0,0,3,0,4,0},
            {0,0,0,0,0,0,0,0,0},
            {0,5,0,6,0,0,3,0,1},
            {0,0,3,0,0,5,0,8,0},
            {0,0,8,2,0,0,5,0,0},
            {0,0,9,7,0,0,0,0,0},
    };

    public static boolean solver (int[][] sudokuGrid) {
        for (int row = 0; row < sudokuGrid.length; row++) {
            for(int column = 0; column < sudokuGrid.length; column++) {
                if (sudokuGrid[row][column] == 0) {
                    for (int tryNumber = 1; tryNumber < 9; tryNumber++) {
                        sudokuGrid[row][column] = tryNumber;
                    }
                }
            }
        }
        return false;
    }

    public boolean isRowValid(int row, int tryNumber) {
                for (int i = 0; i < sudoku.length; i++) {
                    if (sudoku[row][i] == tryNumber) {
                        return true;
                    }
                }
                return false;
    }
}