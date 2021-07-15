import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Combination1 {
    public static void combination_myapproach(int[] boxes, int ci, int ti, int i) {
        // write your code here

        if (ci > ti) {

            for (int j : boxes) {
                System.out.print(j);
            }
            System.out.println();
            return;
        }

        for (int b = i; b < boxes.length; b++) {
            if (boxes[b] == 0) {
                // box empty
                // place obj
                boxes[b] = ci;
                combination_myapproach(boxes, ci + 1, ti, b);
                // unplace
                boxes[b] = 0;
            }
        }
    }

    // cb-current box, tb-total box, isf - items so far, ti-total items,asf=
    // answersofar
    public static void combination_sirapproach(int cb, int tb, int isf, int ti, String asf) {
        // write your code here

        if (cb > tb) {
            if (isf == ti) {
                //
                System.out.println(asf);
            }
            return;
        }

        // yes call
        if (isf + 1 <= ti) {
            combination_sirapproach(cb + 1, tb, isf + 1, ti, asf + "i");
        }

        // no calls
        combination_sirapproach(cb + 1, tb, isf, ti, asf + "-");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        // combination_myapproach(new int[nboxes], 1, ritems, 0);
        combination_sirapproach(1, nboxes, 0, ritems, "");
    }

}
