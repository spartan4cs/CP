import java.util.Scanner;

public class KnightsTour {

    public static void display(int[][] board) {
        // System.out.println("------------------start------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        // System.out.println("-----------------end---------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row = sc.nextInt();// start row
        int col = sc.nextInt();// start col
        int[][] board = new int[n][n];
        printKnightsTour(board, row, col, 1);
    }

    public static int[][] dir = {

            { -2, -1 }, { -2, 1 }, // upper

            { -1, 2 }, { 1, 2 }, // left

            { 2, -1 }, { 2, 1 }, // down

            { -1, -2 }, { 1, -2 } // right

    };

    public static void printKnightsTour(int[][] board, int sr, int sc, int count) {

        if (count == board.length * board.length) {

            board[sr][sc] = count; // for last box
            display(board);
            board[sr][sc] = 0;
            return;
        }

        // mark
        board[sr][sc] = count;

        // knight traversal
        for (int d = 0; d < dir.length; d++) {

            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board.length) {// within board

                if (board[nr][nc] == 0) {// box empty

                    printKnightsTour(board, nr, nc, count + 1);
                }
            }
        }

        // unmark
        board[sr][sc] = 0;

    }
}
