import java.util.*;
import java.io.*;

// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number "tar".
// 4. You are required to calculate and print true or false, if there is a subset the elements of which add 
//      up to "tar" or not.
public class TargetSumSubset {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();

        boolean ans = false;
        // ans = recursion(arr, 0, tar);
        recursion1(arr, 0, tar, ""); // option levl

        // ans = memorization(arr, 0, tar);

        System.out.println(ans);
    }

    public static boolean recursion(int[] arr, int i, int tar) {

        if (i == arr.length) {
            if (tar == 0) {
                return true;
            }
            return false;
        }
        if (tar - arr[i] >= 0) {
            // System.out.println(arr[i]);

            boolean res = recursion(arr, i + 1, tar - arr[i]);
            if (res == true) {
                return true;
            }
        }

        boolean res = recursion(arr, i + 1, tar);
        if (res == true) {
            return true;
        }
        return false;
    }

    // level option
    public static void recursion1(int[] arr, int idx, int tar, String psf) {

        if (tar == 0) {
            System.out.println(true + " " + psf);
        }
        for (int i = idx; i < arr.length; i++) {
            recursion1(arr, i + 1, tar - arr[i], psf + arr[i]);
        }
    }

    public static boolean memorization(int[]arr ,int i  , int tar , boolean[][]) {
        
    }

}
