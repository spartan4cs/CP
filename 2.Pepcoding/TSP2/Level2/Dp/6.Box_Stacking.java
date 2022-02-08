import java.util.Arrays;

class Box_Stacking {

    public static void main(String[] args) {

    }

    // box stacking, link :
    // https://practice.geeksforgeeks.org/problems/box-stacking/1/
    private static class Box implements Comparable<Box> {
        int l;
        int b;
        int h;
        int area;

        public Box(int l, int b, int h) {
            this.l = l;
            this.b = b;
            this.h = h;
            this.area = this.l * this.b;
        }

        public int compareTo(Box o) {

            return o.area - this.area;

        }
    }

    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        Box[] arr = new Box[3 * n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            // LBH
            if (length[i] > width[i]) {
                arr[j++] = new Box(length[i], width[i], height[i]);
            } else {
                arr[j++] = new Box(width[i], length[i], height[i]);
            }
            // HBL
            if (height[i] > width[i]) {
                arr[j++] = new Box(height[i], width[i], length[i]);
            } else {
                arr[j++] = new Box(width[i], height[i], length[i]);
            }
            // LHB
            if (length[i] > height[i]) {
                arr[j++] = new Box(length[i], height[i], width[i]);
            } else {
                arr[j++] = new Box(height[i], length[i], width[i]);
            }
        }
        Arrays.sort(arr);
        int[] dp = new int[3 * n];
        dp[0] = arr[0].h;
        int maxHeight = dp[0];
        for (int i = 1; i < 3 * n; i++) {
            int max = 0;
            for (int k = i - 1; k >= 0; k--) {
                if (arr[k].l > arr[i].l && arr[k].b > arr[i].b) {
                    max = Math.max(max, dp[k]);
                }
            }
            dp[i] = max + arr[i].h;
            maxHeight = Math.max(maxHeight, dp[i]);
        }
        return maxHeight;
    }
}
