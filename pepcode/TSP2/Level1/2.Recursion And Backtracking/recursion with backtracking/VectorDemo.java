class VectorDemo {

    public static void demo() {

        // matrix 5x4;
        int n = 5;
        int m = 4;

        int radius = Math.max(n, m);

        int r = 1; // current r
        int c = 1; // currnt c

        int[] rdir = { -1, 0, 1, 0 };
        int[] cdir = { 0, 1, 0, -1 };

        for (int rad = 1; rad <= radius; rad++) {

            // for each radius, get direction data
            for (int dir = 0; dir < rdir.length; dir++) {

                int nr = r + rad * rdir[dir];
                int nc = c + rad * cdir[dir];

                if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= m - 1) {
                    System.out.println("Radius : " + rad + " r : " + nr + " c : " + nc);
                }
            }
        }

        System.out.println("-------------------------------------");
        for (int dir = 0; dir < rdir.length; dir++) {
            // for each direction, get radius data
            for (int rad = 1; rad <= radius; rad++) {
                int nr = r + rad * rdir[dir];
                int nc = c + rad * cdir[dir];

                if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= m - 1) {
                    System.out.println("Direction : " + dir + " r : " + nr + " c : " + nc);
                }
            }
        }
    }

    public static void main(String[] args) {

        demo();
    }
}