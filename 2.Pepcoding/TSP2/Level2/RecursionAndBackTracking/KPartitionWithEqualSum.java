import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KPartitionWithEqualSum {
    public static void solution(int[] arr, int vidx, int n, int k, int[] subsetSum, int nos,
            ArrayList<ArrayList<Integer>> ans, int sum) {

        // write your code here

        if (vidx == arr.length) {

            if (nos == k) {

                boolean allMatch = Arrays.stream(subsetSum).allMatch(t -> t == sum);
                if (allMatch) {

                    for (ArrayList<Integer> al : ans) {
                        System.out.print(al + " ");
                    }
                    System.out.println();
                }
            }

            return;
        }

        int num = arr[vidx];
        for (int i = 0; i < k; i++) {

            if (subsetSum[i] == 0) {
                // empty set
                subsetSum[i] += num;
                ans.get(i).add(num);
                solution(arr, vidx + 1, n, k, subsetSum, nos + 1, ans, sum);
                subsetSum[i] -= num;
                ans.get(i).remove(ans.get(i).size() - 1);
                break;
            } else {

                subsetSum[i] += num;
                ans.get(i).add(num);
                solution(arr, vidx + 1, n, k, subsetSum, nos, ans, sum);
                subsetSum[i] -= num;
                ans.get(i).remove(ans.get(i).size() - 1);

            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        // if k is equal to 1, then whole array is your answer
        if (k == 1) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println("]");
            return;
        }
        // if there are more subsets than no. of elements in array or sum of all
        // elements is not divisible by k
        if (k > n || sum % k != 0) {
            System.out.println("-1");
            return;
        }
        int[] subsetSum = new int[k];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(arr, 0, n, k, subsetSum, 0, ans, sum / k);
    }

}
