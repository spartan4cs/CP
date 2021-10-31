import java.util.Scanner;

class NQueenSubsetApproach {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];

        printNQueens(board, 0, 0, 0, "");// subset approach
    }

    public static int dir[][] = {

            { -1, -1 }, { -1, 0 }, { -1, 1 } // left diagonal , up ,right diagonal

    };

    // check if queen can be attacked only in updward direction
    public static boolean isValidToPlace(int[][] board, int sr, int sc) {

        int radius = board.length;

        for (int rad = 1; rad < radius; rad++) {
            for (int d = 0; d < dir.length; d++) {
                int nr = sr + rad * dir[d][0];
                int nc = sc + rad * dir[d][1];

                if (nr >= 0 && nr < radius && nc >= 0 && nc < radius) {// wihiin board
                    if (board[nr][nc] == 1)
                        return false;
                }

            }
        }

        return true;
    }

    // qsf- queen placed so far
    // asf - ans placed so far

    public static void printNQueens(int[][] board, int sr, int sc, int qsf, String asf) {

        // base
        if (sr == board.length) {
            if (qsf == board.length) { // all queens are placed
                System.out.println(asf + ".");
            }
            return;
        }

        // yes call only if it is valid to place the queen
        if (isValidToPlace(board, sr, sc) == true) {
            // mark
            board[sr][sc] = 1;
            // call
            printNQueens(board, sr + 1, 0, qsf + 1, asf + sr + "-" + sc + ", ");
            // unmark
            board[sr][sc] = 0;
        }

        // condition check for no call
        if (sc + 1 < board[0].length) { // valid column
            // no call
            printNQueens(board, sr, sc + 1, qsf, asf);

        } else { // invalid column
            /// no call
            printNQueens(board, sr + 1, 0, qsf, asf);

        }

    }
}