/**
 * https://leetcode.com/problems/container-with-most-water/
 */

public class Leet_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            int res = 0;
            if (height[i] <= height[j]) {
                res = height[i] * (j - i); // j-i is width
                i++;
            } else {
                res = height[j] * (j - i); // j-i is width
                j--;
            }

            if (res > ans)
                ans = res;
        }
        return ans;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 1 };
        System.out.println(maxArea(arr));
    }
}
