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
    public static void combination1(int cb, int tb, int isf, int ti, String asf) {
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
            combination1(cb + 1, tb, isf + 1, ti, asf + "i");
        }

        // no calls
        combination1(cb + 1, tb, isf, ti, asf + "-");
    }

    // ci-> current item, ti-> total item, lb-> last box used
    public static void combinations2(int[] boxes, int ci, int ti, int lb) {
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print("i");
                }
            }
            System.out.println();
            return;
        }

        for (int b = lb; b < boxes.length; b++) {
            if (boxes[b] == 0) {
                // place ci item on bth box
                boxes[b] = ci;
                combinations2(boxes, ci + 1, ti, b);
                // unplace
                boxes[b] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        // combination_myapproach(new int[nboxes], 1, ritems, 0);
        // combination1(1, nboxes, 0, ritems, "");
        combinations2(new int[nboxes], 1, ritems, 0);
    }

}
