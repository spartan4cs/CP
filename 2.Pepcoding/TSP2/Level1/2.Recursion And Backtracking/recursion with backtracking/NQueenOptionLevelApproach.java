import java.util.Scanner;

public class NQueenOptionLevelApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        printNQueens(board, 0, 0, "");
    }

    public static int dir[][] = {

            { 0, 1 }, { 1, 1 }, { 1, -0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }

    };

    public static boolean isValidTOPlace(int[][] board, int sr, int sc) {

        int radius = board.length;
        for (int rad = 1; rad < radius; rad++) {

            for (int d = 0; d < dir.length; d++) {

                int nr = sr + rad * dir[d][0];
                int nc = sc + rad * dir[d][1];
                if (nr >= 0 && nr < radius & nc >= 0 && nc < radius) {// within board
                    if (board[nr][nc] == 1) // if queen getting attacked
                        return false;
                }
            }
        }
        return true;

    }

    // queen placed sofar
    // ans so far
    // column as options
    // row as level
    public static void printNQueens(int[][] board, int row, int qsf, String asf) {

        // here we are not chekc the condition of number of queen placed because
        // we are calling recursive only when we place;
        if (row == board.length) {
            System.out.println(asf + ".");
            return;
        }

        for (int col = 0; col < board.length; col++) {// options

            if (isValidTOPlace(board, row, col) == true) {

                // mark
                board[row][col] = 1;

                printNQueens(board, row + 1, qsf + 1, asf + row + "-" + col + ", ");
                // unmark
                board[row][col] = 0;

            }

        }
    }
}
