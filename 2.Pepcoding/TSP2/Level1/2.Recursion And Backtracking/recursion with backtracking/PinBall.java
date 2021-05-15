public class PinBall {

    // normal direction
    public static int[] rdir = { -1, 0, 1, 0 };
    public static int[] cdir = { 0, -1, 0, 1 };
    public static char[] charr = { 't', 'l', 'd', 'r' };

    // backward obstacle direction (l->t ,t->l, r->d, d->r) \

    public static int[] rdirb = { 0, -1, 0, 1 };
    public static int[] cdirb = { -1, 0, 1, 0 };
    public static char[] charrb = { 'l', 't', 'r', 'd' };

    // forward obstacle dirction (l->d, d->l,r->t,t->r) /
    public static int[] rdirf = { 0, 1, 0, -1 };
    public static int[] cdirf = { 1, 0, -1, 0 };
    public static char[] charrf = { 'r', 'd', 'l', 't' };

    // direction approach
    public static void traverse_dir(char[][] board, int sr, int sc, int dr, int dc, char currDir, String asf,
            String coordinates) {

        if (sr == -1 || sc == -1 || sr >= board.length || sc >= board[0].length) {

            System.out.println(asf);
            System.out.println(coordinates);

            return;
        }

        if (sr >= 0 && sc >= 0 && sr <= dr && sc <= dc) {

            int nr = 0;
            int nc = 0;
            char ndir = 'l';
            // t or l or d or right jau shakto
            // jar i is your current direction - la jaar ahe
            for (int i = 0; i < charr.length; i++) {

                if (currDir == charr[i]) {
                    if (board[sr][sc] == '\\') {// obstacle 1 ala tar
                        nr = sr + rdirb[i]; // backward obstacle direction
                        nc = sc + cdirb[i];
                        ndir = charrb[i];

                    } else if (board[sr][sc] == '/') { // obstacle 2 tar
                        nr = sr + rdirf[i];// forward obstacle direction
                        nc = sc + cdirf[i];
                        ndir = charrf[i];
                    } else {
                        nr = sr + rdir[i]; // normal direction
                        nc = sc + cdir[i];
                        ndir = charr[i];
                    }
                }

            }
            traverse_dir(board, nr, nc, dr, dc, ndir, asf + ndir, coordinates + "(" + sr + "," + sc + ")");

        }
    }

    // allcals checking
    public static void traverse(char[][] board, int sr, int sc, int dr, int dc, char currDir, String asf,
            String coordinates) {

        if (sr == -1 || sc == -1 || sr >= board.length || sc >= board[0].length) {

            System.out.println(asf);
            System.out.println(coordinates);

            return;
        }

        if (sr >= 0 && sc >= 0 && sr <= dr && sc <= dc) {

            if (board[sr][sc] == '\\') {// obstacle 1 (l->t ,t->l, r->d, d->r)
                if (currDir == 'l') {// based on current direction i am changing the direction
                    traverse(board, sr - 1, sc, dr, dc, 't', asf + "t", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 't') {
                    traverse(board, sr, sc - 1, dr, dc, 'l', asf + "l", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 'r') {
                    traverse(board, sr + 1, sc, dr, dc, 'd', asf + "d", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 'd') {
                    traverse(board, sr, sc + 1, dr, dc, 'r', asf + "r", coordinates + "(" + sr + "," + sc + ")");
                }
            } else if (board[sr][sc] == '/') {// obstacle 2(l->d, d->l,r->t,t->r)
                if (currDir == 'l') {// based on current direction i am changing the direction
                    traverse(board, sr + 1, sc, dr, dc, 'd', asf + "d", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 't') {
                    traverse(board, sr, sc + 1, dr, dc, 'r', asf + "r", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 'r') {
                    traverse(board, sr - 1, sc, dr, dc, 't', asf + "t", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 'd') {
                    traverse(board, sr, sc - 1, dr, dc, 'l', asf + "l", coordinates + "(" + sr + "," + sc + ")");
                }
            } else {
                // no obstacle
                // move in exitiing direction
                if (currDir == 't') {
                    traverse(board, sr - 1, sc, dr, dc, currDir, asf + currDir,
                            coordinates + "(" + sr + "," + sc + ")");

                } else if (currDir == 'l') {

                    traverse(board, sr, sc - 1, dr, dc, currDir, asf + currDir,
                            coordinates + "(" + sr + "," + sc + ")");

                } else if (currDir == 'd') {
                    traverse(board, sr + 1, sc, dr, dc, currDir, asf + currDir,
                            coordinates + "(" + sr + "," + sc + ")");

                } else if (currDir == 'r') {
                    traverse(board, sr, sc + 1, dr, dc, currDir, asf + currDir,
                            coordinates + "(" + sr + "," + sc + ")");

                }

            }

        }
    }

    public static void main(String[] args) {

        // 0 1 2 3
        // 0 / / \
        // 1 \
        // 2 \ 0
        // char[][] board = {

        // { '/', '/', '\\', '0' },

        // { '0', '0', '\\', '0' },

        // { '0', '\\', '0', '0' }

        // };

        // llttrdlltrt
        char[][] board = {

                { '/', '/', '\\', '0' },

                { '\\', '0', '/', '0' },

                { '0', '\\', '0', '0' }

        };
        traverse(board, 2, 3, 2, 3, 'l', "", "");
        traverse_dir(board, 2, 3, 2, 3, 'l', "", "");

        // for (int i = 0; i < board.length; i++) {
        // for (int j = 0; j < board[0].length; j++) {
        // System.out.println(board[i][j] + " ");
        // }
        // System.out.println();
        // }
    }
}
