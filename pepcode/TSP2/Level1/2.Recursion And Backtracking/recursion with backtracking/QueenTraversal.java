public class QueenTraversal {

    public static void demo() {

        // matrix 5x4;
        int n = 8;
        int m = 8;

        int radius = Math.max(n, m);

        int r = 3; // current r
        int c = 3; // currnt c

        int[][] dir = {

                { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }

        };

        for (int d = 0; d < dir.length; d++) {

            for (int rad = 1; rad <= radius; rad++) {
                int nr = r + rad * dir[d][0];
                int nc = c + rad * dir[d][1];

                if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= m - 1) {
                    System.out.println("Direction : " + d + " -> " + " ( " + nr + " , " + nc + " )");

                }
            }
        }
    }

    public static void main(String[] args) {
        demo();
    }
}
