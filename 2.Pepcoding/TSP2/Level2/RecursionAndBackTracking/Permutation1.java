import java.io.BufferedReader;
import java.io.InputStreamReader;

class Permutation1 {

    // using level items
    // option boxex
    public static void permutations1(int[] boxes, int ci, int ti) {
        // write your code here

        if (ci > ti) {

            for (int i : boxes) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                // box empty
                // place obj
                boxes[i] = ci;
                permutations1(boxes, ci + 1, ti);
                // unplace
                boxes[i] = 0;
            }
        }
    }

    // using yes and no call
    // level-box
    // option- items
    // cb -current box, tb=total box,isf = item so far,asf = ans so far
    public static void permutations2(int[] items, int cb, int tb, int isf, int ti, String asf) {
        // write your code here

        if (cb > tb) {
            if (isf == ti) {
                System.out.println(asf);
            }
            return;
        }

        // yes call
        for (int i = 0; i < items.length && isf < ti; i++) {

            if (items[i] == 0) {
                // mark
                items[i] = 1;
                permutations2(items, cb + 1, tb, isf + 1, ti, asf + "" + (i + 1));
                // unmark
                items[i] = 0;
            }
        }
        // no call
        permutations2(items, cb + 1, tb, isf, ti, asf + "0");

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        // permutations1(new int[nboxes], 1, ritems);
        permutations2(new int[ritems], 0, nboxes - 1, 0, ritems, "");

    }

}