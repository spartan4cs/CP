import java.io.*;
import java.util.*;

// 3 0 6 5 0 8 4 0 0
// 5 2 0 0 0 0 0 0 0
// 0 8 7 0 0 0 0 3 1
// 0 0 3 0 1 0 0 8 0
// 9 0 0 8 6 3 0 0 5
// 0 5 0 0 9 0 6 0 0
// 1 3 0 0 0 0 2 5 0
// 0 0 0 0 0 0 0 7 4
// 0 0 5 2 0 6 3 0 0
public class Sudoku {

    public static void solveSudoku(int[][] board, int i, int j) {
        // write yopur code here

        if (i == board.length) {
            display(board);
            return;
        }
        //
        int ni = 0;
        int nj = 0;
        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }
        if (board[i][j] != 0) {
            solveSudoku(board, ni, nj);
        } else {
            for (int val = 1; val <= 9; val++) {
                if (isCorrectOption(board, i, j, val)) {
                    board[i][j] = val;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static boolean isCorrectOption(int[][] board, int i, int j, int op) {
        // for col

        for (int k = 0; k < board[0].length; k++) {
            if (board[i][k] == op) {
                return false;
            }
        }
        // for row

        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == op) {
                return false;
            }
        }
        // for box

        int ni = i / 3 * 3;
        int nj = j / 3 * 3;
        for (int k = ni; k < ni + 3; k++) {
            for (int k2 = nj; k2 < nj + 3; k2++) {
                if (board[k][k2] == op) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
    }
}
