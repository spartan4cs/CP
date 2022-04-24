import java.io.*;
import java.util.*;

public class Permutation1_ItemOnLevel {

  public static void permutations(int[] boxes, int ci, int ti) {
    // write your code here

    if (ci > ti) {
      for (int b = 0; b < boxes.length; b++) {
        System.out.print(boxes[b]);
      }
      System.out.println();
      return;
    }

    //items on level
    for (int b = 0; b < boxes.length; b++) {
      if (boxes[b] == 0) {
        boxes[b] = ci;
        permutations(boxes, ci + 1, ti);
        boxes[b] = 0;

      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}
