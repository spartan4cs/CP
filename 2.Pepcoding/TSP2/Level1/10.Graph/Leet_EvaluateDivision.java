import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Leet_EvaluateDivision {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            System.out.println(new B().calcEquation(equations, values, queries));
        }
    }
}

class B {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

    }
}