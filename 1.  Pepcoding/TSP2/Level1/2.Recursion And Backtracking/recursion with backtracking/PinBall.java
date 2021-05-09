public class PinBall {

    public static void traverse(char[][] board, int sr, int sc, int dr, int dc, char currDir, String asf,
            String coordinates) {

        if (sr == -1 || sc == -1 || sr >= board.length || sc >= board[0].length) {

            System.out.println(asf);
            System.out.println(coordinates);

            return;
        }

        if (sr >= 0 && sc >= 0 && sr <= dr && sc <= dc) {

            if (board[sr][sc] == '\\') {
                if (currDir == 'l') {
                    traverse(board, sr - 1, sc, dr, dc, 't', asf + "t", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 't') {
                    traverse(board, sr, sc - 1, dr, dc, 'l', asf + "l", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 'r') {
                    traverse(board, sr + 1, sc, dr, dc, 'd', asf + "d", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 'd') {
                    traverse(board, sr, sc + 1, dr, dc, 'r', asf + "r", coordinates + "(" + sr + "," + sc + ")");
                }
            } else if (board[sr][sc] == '/') {
                if (currDir == 'l') {
                    traverse(board, sr + 1, sc, dr, dc, 'd', asf + "d", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 't') {
                    traverse(board, sr, sc + 1, dr, dc, 'r', asf + "r", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 'r') {
                    traverse(board, sr - 1, sc, dr, dc, 't', asf + "t", coordinates + "(" + sr + "," + sc + ")");
                } else if (currDir == 'd') {
                    traverse(board, sr, sc - 1, dr, dc, 'l', asf + "l", coordinates + "(" + sr + "," + sc + ")");
                }
            } else {
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
        // for (int i = 0; i < board.length; i++) {
        // for (int j = 0; j < board[0].length; j++) {
        // System.out.println(board[i][j] + " ");
        // }
        // System.out.println();
        // }
    }
}
