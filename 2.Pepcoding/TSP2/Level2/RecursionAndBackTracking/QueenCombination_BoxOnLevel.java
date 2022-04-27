import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueenCombination_BoxOnLevel {

    // level box
    // option yes / no for item
    // qpsf - queen placed so far
    // tq = total queen
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {
        // write your code here

        if (row == tq) { // nned to go till the last row
            if (qpsf == tq) { // print tabhi karna jab dono queen placed ho
                System.out.println(asf);
            }
            return;
        }

        if (col + 1 < tq) {
            // yes call
            if (qpsf < tq) // to avoid unnecessary call if all the queen are placed
                queensCombinations(qpsf + 1, tq, row, col + 1, asf + "q");
            // no call
            queensCombinations(qpsf, tq, row, col + 1, asf + "-");
        } else {
            // yes call
            queensCombinations(qpsf + 1, tq, row + 1, 0, asf + "q\n");
            // no call
            queensCombinations(qpsf, tq, row + 1, 0, asf + "-\n");
        }
    }

    // Other way

    public static void queensCombinations1(int qpsf, int tq, int row, int col, String asf) {
        // write your code here

        // base case
        if (row == tq) {
            if (qpsf == tq)
                System.out.println(asf);

            return;
        }

        // box on level
        // option are either yes or no

        String sep = "";
        int nr = row;
        int nc = col;
        if (col < tq - 1) {
            nr = row;
            nc = col + 1;
            sep = "";
        } else {
            nr = row + 1;
            nc = 0;
            sep = "\n";
        }

        // yes call
        queensCombinations1(qpsf + 1, tq, nr, nc, asf + "q" + sep);

        // no call
        queensCombinations1(qpsf, tq, nr, nc, asf + "-" + sep);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, 0, "");
    }
}
