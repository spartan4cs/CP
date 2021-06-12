import java.util.HashMap;
import java.util.Scanner;

public class GetCommonElements2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        printCommonElement(arr1, arr2);
    }

    public static void printCommonElement(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : arr1) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        for (int e : arr2) {
            if (map.containsKey(e)) {
                if (map.get(e) > 0) {
                    System.out.println(e);
                    map.put(e, map.get(e) - 1);
                }
            }
        }
    }
}
