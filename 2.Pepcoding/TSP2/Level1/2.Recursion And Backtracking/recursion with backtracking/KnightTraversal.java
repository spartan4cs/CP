public class KnightTraversal {

    // Note there will be no radius

    public static void demo() {
        // matrix 5x4;
        int n = 8;
        int m = 8;

        int r = 4; // current r
        int c = 4; // currnt c

        int[][] dir = {

                { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }

        };

        for (int d = 0; d < dir.length; d++) {

            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= m - 1) {
                System.out.println("Direction : " + d + " -> " + " ( " + nr + " , " + nc + " )");
            }
        }
    }

    public static void main(String[] args) {
        demo();
    }
}
