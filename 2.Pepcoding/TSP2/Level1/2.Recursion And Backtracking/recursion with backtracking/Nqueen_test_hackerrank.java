import java.util.*;
import java.util.Scanner;

public class Nqueen_test_hackerrank {

    public static int dir[][] = {

            { 0, 1 }, { 1, 1 }, { 1, -0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }

    };

    public static boolean isValidTOPlace(char[][] board, int sr, int sc) {

        int radius = board.length;
        for (int rad = 1; rad < radius; rad++) {

            for (int d = 0; d < dir.length; d++) {

                int nr = sr + rad * dir[d][0];
                int nc = sc + rad * dir[d][1];
                if (nr >= 0 && nr < radius & nc >= 0 && nc < radius) {// within board
                    if (board[nr][nc] == 'Q') // if queen getting attacked
                        return false;
                }
            }
        }
        return true;

    }

    public static List<List<String>> printNQueens(char[][] board, int row, int qsf, String asf,
            List<List<String>> ans) {

        // here we are not chekc the condition of number of queen placed because
        // we are calling recursive only when we place;
        if (row == board.length) {
            List<String> bres = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board[0].length; j++) {
                    sb.append(board[i][j]);
                }
                bres.add(sb.toString());
            }
            ans.add(bres);
            return ans;
        }

        for (int col = 0; col < board.length; col++) {// options

            if (isValidTOPlace(board, row, col) == true) {

                // mark
                board[row][col] = 'Q';

                ans = printNQueens(board, row + 1, qsf + 1, asf + row + "-" + col + ", ", ans);
                // unmark
                board[row][col] = '.';

            }

        }
        return ans;
    }

    public static List<List<String>> solveNQueens(int n) {
        // write your code here

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return printNQueens(board, 0, 0, "", new ArrayList<>());

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<List<String>> res = solveNQueens(n);
        System.out.println(res);
    }

}
