import java.util.*;
import java.io.*;

class PaintFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int same = 0;
        int distinct = k;
        for (int i = 2; i <= n; i++) {
            int n_same = distinct;
            int n_distinct = (same + distinct) * (k - 1);
            // update
            same = n_same;
            distinct = n_distinct;
        }

        System.out.println(same + distinct);
    }

}
