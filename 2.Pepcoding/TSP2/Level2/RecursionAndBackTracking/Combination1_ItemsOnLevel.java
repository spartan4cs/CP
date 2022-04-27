import java.io.*;
import java.util.*;

public class Combination1_ItemsOnLevel {

  public static void combinations(int[] boxes, int ci, int ti, int lb) {
    // write your code here

    if (ci > ti) {
      for (int b = 0; b < boxes.length; b++) {
        if (boxes[b] == 0) {
          System.out.print("-");

        } else {
          System.out.print("i");

        }

      }
      System.out.println();
      return;
    }

    // items on level
    // there are identical items
    // i .e on next level for iteration1,you should start from next box
    for (int b = lb + 1; b < boxes.length; b++) {
      if (boxes[b] == 0) {
        boxes[b] = ci;
        combinations(boxes, ci + 1, ti, b);
        boxes[b] = 0;

      }
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, -1);
  }

}
