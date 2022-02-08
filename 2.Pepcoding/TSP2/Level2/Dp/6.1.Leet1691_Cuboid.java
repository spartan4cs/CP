import java.util.Arrays;

class Leet1691_Cuboid {
    public static void main(String[] args) {

    }

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
            // you can sort by volume as well
            if (o.area != this.area)
                return o.area - this.area;
            else
                return o.h - this.h;
        }
    }

    // leetcode 1691,
    // https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
    public int maxHeight(int[][] cuboids) {
        Box[] arr = new Box[cuboids.length];
        int j = 0;
        for (int[] box : cuboids) {
            Arrays.sort(box); // to have max height value
            arr[j++] = new Box(box[0], box[1], box[2]);
        }
        Arrays.sort(arr);

        int[] dp = new int[arr.length];
        dp[0] = arr[0].h;
        int maxHeight = dp[0];
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int k = i - 1; k >= 0; k--) {
                if (arr[k].l >= arr[i].l && arr[k].b >= arr[i].b && arr[k].h >= arr[i].h) {
                    max = Math.max(max, dp[k]);
                }
            }
            dp[i] = max + arr[i].h;
            maxHeight = Math.max(maxHeight, dp[i]);
        }
        return maxHeight;
    }
}
