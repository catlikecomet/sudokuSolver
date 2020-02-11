import java.util.Arrays;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args) {
        //AHHH 2 Dimensional ARRAYS OMG :(
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 2, 1, 0, 0},
                {0, 0, 4, 0, 0, 8, 7, 0, 0},
                {0, 2, 0, 3, 0, 0, 9, 0, 0},
                {6, 0, 2, 0, 0, 3, 0, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 5, 0, 6, 0, 0, 3, 0, 1},
                {0, 0, 3, 0, 0, 5, 0, 8, 0},
                {0, 0, 8, 2, 0, 0, 5, 0, 0},
                {0, 0, 9, 7, 0, 0, 0, 0, 0},
        };

        if (Sudoku.solver(board)) {
            //I needed to look up how to print 2d arrays to a string
            String solved = Arrays
                    .stream(board)
                    .map(Arrays::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
            System.out.println(solved);
        } else  {
            System.out.println("Unable to find solution");
        }
    }
}
