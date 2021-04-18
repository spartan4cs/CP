import java.util.*;

public class GetMazePathGeneric {

    public static ArrayList<String> mazePath(int sr, int sc, int er, int ec, int[][] dir, String[] dirS) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        // direction
        for (int d = 0; d < dir.length; d++) {
            // from current row and column
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            // specified the range
            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                ArrayList<String> recAns = mazePath(r, c, er, ec, dir, dirS);
                for (String s : recAns) {
                    ans.add(dirS[d] + s);
                }
            }
        }

        return ans;
    }

    public static ArrayList<String> mazePathGenric(int sr, int sc, int er, int ec, int[][] dir, String[] dirS,
            int Rad) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        // direction
        for (int d = 0; d < dir.length; d++) {
            // magnitude/jumps
            for (int rad = 1; rad <= Rad; rad++) {

                // will move with magnitude rad*unit Vector from current point sr and sc
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                // range specified
                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    ArrayList<String> recAns = mazePathGenric(r, c, er, ec, dir, dirS, Rad);
                    for (String s : recAns) {
                        ans.add(dirS[d] + rad + s);
                    }
                } else
                    // beyond range
                    break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] dir = { { 1, 0 }, { 1, 1 }, { 0, 1 } };
        String[] dirS = { "V", "D", "H" };
        int n = 1;
        int m = 4;
        System.out.println(mazePathGenric(0, 0, n - 1, m - 1, dir, dirS, Math.max(n, m)));
        System.out.println(mazePath(0, 0, n - 1, m - 1, dir, dirS));
    }
}
