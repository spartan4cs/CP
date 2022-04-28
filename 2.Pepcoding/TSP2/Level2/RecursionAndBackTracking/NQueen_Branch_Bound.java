import java.util.Scanner;

public class NQueen_Branch_Bound {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[][] chess = new boolean[n][n];
        boolean col[] = new boolean[n];
        boolean ncol[] = new boolean[2 * n - 1];
        boolean rcol[] = new boolean[2 * n - 1];

        nqueen(chess, 0, col, ncol, rcol, "");
    }

    private static void nqueen(boolean[][] chess, int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag,
            String asf) {

        if (row == chess.length) {
            System.out.println(asf + ".");
            return;
        }

        for (int col = 0; col < chess.length; col++) {

            if (!chess[row][col] && !cols[col] && !ndiag[row + col] && !rdiag[row - col + chess.length - 1]) {

                chess[row][col] = true;
                cols[col] = true;
                ndiag[row + col] = true;
                rdiag[row - col + chess.length - 1] = true;
                nqueen(chess, row + 1, cols, ndiag, rdiag, asf + row + "-" + col + ", ");
                chess[row][col] = false;
                cols[col] = false;
                ndiag[row + col] = false;
                rdiag[row - col + chess.length - 1] = false;
            }

        }
    }

}
