public class Sudoku {

//    public static boolean solver (int[][] sudokuGrid) {
//        for (int row = 0; row < sudokuGrid.length; row++) {
//            for(int column = 0; column < sudokuGrid.length; column++) {
//                if (sudokuGrid[row][column] == 0) {
//                    for (int tryNumber = 1; tryNumber < 9; tryNumber++) {
//                        sudokuGrid[row][column] = tryNumber;
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public static boolean isRowValid(int[][] board, int row, int tryNumber) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == tryNumber) {
                return false;
            }
        }
        return true;
    }

    public static boolean isColumnValid(int[][] board, int column, int tryNumber) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == tryNumber)
                return false;
        }
        return true;
    }

    public static boolean is3x3Valid(int[][] board, int row, int column, int tryNumber) {
//      getting the 3x3 grid
        int rowBox = row - (row % 3);
        int columnBox = column - (column % 3);

        for (int x = rowBox; x < rowBox + 3; x++) {
            for (int y = columnBox; y < columnBox + 3; y++) {
                if (board[x][y] == tryNumber) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean areNumbersValid(int[][] board, int row, int column, int tryNumber) {
        if (isRowValid(board, row, tryNumber) && isColumnValid(board, column, tryNumber) && is3x3Valid(board, row, column, tryNumber)) {
            return true;
        }
        return false;
    }

    public static boolean solver(int[][] board) {
        int row = 0;
        int column = 0;
        boolean isSpaceZero = true;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] == 0) {
                    //filling up the square with a number so it is no longer empty
                    row = x;
                    column = y;
                    isSpaceZero = false;
                    break;
                }
            }
            //if there are still empty spaces
            if (!isSpaceZero) {
                break;
            }
        }
        //if there is no empty spaces left
        if (isSpaceZero) {
            return true;
        }

        //backtracking stuff
        for (int number = 1; number <= 9; number++) {
            if (areNumbersValid(board, row, column, number)) {
                board[row][column] = number;
                if (solver(board)) {
                    return true;
                } else {
                    //if number is invalid change it back to a 0
                    board[row][column] = 0;
                }
            }
        }
        return false;
    }

    public static void printBoard(int[][] board) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.println(board[x][y]);
            }
        }
    }
}
