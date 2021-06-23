import java.util.ArrayList;
import java.util.Scanner;

public class Div2D197 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        int si = 0;
        int sj = 0;
        for (int i = 0; i < n; i++) {

            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'S') {
                    si = i;
                    sj = j;
                }
            }

        }

        boolean ans = getAns(arr, si, sj);
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.println(arr[i][j]);
        // }
        // }

    }

    static int xdir[] = { -1, 0, 1, 0 };
    static int ydir[] = { 0, -1, 0, 1 };

    public static boolean getAns(char[][] arr, int si, int sj) {

        for (int d = 0; d < 4; d++) {
            int ni = si + xdir[d];
            int nj = sj + ydir[d];
            if (ni == -1) {
                ni += arr.length;
            }
            if (nj == -1) {
                nj += arr[0].length;
            }
            if (ni == arr.length) {
                ni = 0;
            }
            if (nj == arr[0].length) {
                nj = 0;
            }
            if (arr[ni][nj] == '.' || arr[si][sj] == 'S') {
                getAns(arr, ni, nj);
            }
        }
    }
}
