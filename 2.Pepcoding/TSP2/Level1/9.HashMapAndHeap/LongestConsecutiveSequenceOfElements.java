import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSequenceOfElements {
    public static void main(String[] args) {

        // ignore duplicates
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        printLCS(arr1);

    }

    public static void printLCS(int[] arr) {

        HashMap<Integer, Boolean> map = new HashMap<>();
        // make all true
        for (int key : arr) {
            map.put(key, true);

        }

        // keep only start point true and remaining consecutive false
        // if 1 2 3 4
        // then 1 will be true and remaining will be falses
        for (int key : arr) {
            if (map.containsKey(key - 1)) {
                map.put(key, false);
            }
        }

        // maintain the start point and max length
        int startpoint = 0;
        int maxlength = 0;
        for (int key : arr) {
            if (map.get(key) == true) {
                // this key is start point
                int len = 1;
                int st = key;

                while (map.containsKey(key + 1)) {
                    key++;
                    len++;
                    
                }
                // update max
                if (len > maxlength) {
                    maxlength = len;
                    startpoint = st;
                }
                map.put(st, false);// to duplicate present in arrso ignore it
            }

        }

        // print
        for (int i = 0; i < maxlength; i++) {
            System.out.println(startpoint);
            startpoint++;
        }

    }
}
