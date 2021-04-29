import java.util.Scanner;

public class Sorto12 {
    public static void sort012(int[] arr) {

        int i = 0; // first unsolved
        int j = 0; // first 1
        int k = arr.length - 1; // last unsolved
        while (i <= k) {

            if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;

            } else if (arr[i] == 1) {

                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, k);

                k--;
            }
        }

    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        sort012(arr);
        print(arr);
    }
}
