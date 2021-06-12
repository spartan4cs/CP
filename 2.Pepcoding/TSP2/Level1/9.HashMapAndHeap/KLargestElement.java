
import java.io.*;
import java.util.*;

public class KLargestElement {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        // write your code here
        printKLargestElement(arr, k);
    }

    public static void printKLargestElement(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // maintain pq of k element
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);

        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

}