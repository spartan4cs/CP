/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
//1 2 3 4 
//5 6 7 
// @lc code=start
class Solution {
    // O(n+m) tim ecomplexity
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int ans[] = new int[l1 + l2];

        while (i < l1 && j < l2) {

            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }

        }
        while (i < l1) {
            ans[k++] = nums1[i++];
        }
        while (j < l2) {
            ans[k++] = nums2[j++];
        }

        double fans = 0.0;
        int l = ans.length / 2;
        if (ans.length % 2 == 1) {
            fans = ans[l];
        } else {
            fans = (ans[l] + ans[l - 1]) / 2.0;
        }
        return fans;

    }

    // using binary search
    // O(log(n+m))

    // 1 2 3 |4 5 6
    // 1 2 |3
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // need to make valid segregation
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 > l2) {
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        l1 = nums1.length;
        l2 = nums2.length;

        int l = 0;
        int r = l1;
        double median = 0.0;
        while (l <= r) {

            int total = l1 + l2; // 9(5|4)
            int al = (l + r) / 2; // 3
            int bl = (total + 1) / 2 - al; // 2
            int aleft_m1 = al == 0 ? Integer.MIN_VALUE : nums1[al - 1];
            int aleft = al == nums1.length ? Integer.MAX_VALUE : nums1[al];
            int bleft_m1 = bl == 0 ? Integer.MIN_VALUE : nums2[bl - 1];
            int bleft = bl == nums2.length ? Integer.MAX_VALUE : nums2[bl];
            // valid segregation
            if (aleft_m1 <= bleft && bleft_m1 <= aleft) {
                if (total % 2 == 0) {
                    int lmax = Math.max(aleft_m1, bleft_m1);
                    int rmin = Math.min(aleft, bleft);
                    median = (lmax + rmin) / 2.0;
                } else {
                    median = Math.max(aleft_m1, bleft_m1);
                }
                break;
            }

            else if (aleft_m1 > bleft) {
                r = al - 1;
            } else if (bleft_m1 > aleft) {
                l = al + 1;
            }
        }
        return median;
    }
}
// @lc code=end
