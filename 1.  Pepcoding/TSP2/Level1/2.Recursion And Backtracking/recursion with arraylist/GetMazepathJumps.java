import java.util.*;

public class GetMazepathJumps {

    public static ArrayList<String> getMazePathWithJumpStupid(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (sr > dr || sc > dc) {
            return new ArrayList<>();

        }

        // horizontal calls

        ArrayList<String> hres = getMazePathWithJumpStupid(sr, sc + 1, dr, dc);
        // diagonal calls
        ArrayList<String> dres = getMazePathWithJumpStupid(sr + 1, sc + 1, dr, dc);
        // vertical calls
        ArrayList<String> vres = getMazePathWithJumpStupid(sr + 1, sc, dr, dc);

        ArrayList<String> myres = new ArrayList<>();

        for (String s : hres) {
            myres.add("h" + s);

        }
        for (String s : dres) {
            myres.add("d" + s);

        }
        for (String s : vres) {
            myres.add("v" + s);

        }

        return myres;

    }

    public static ArrayList<String> getMazePathWithJumpSmart(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> myres = new ArrayList<>();
        // horizontal calls
        for (int jump = 1; jump <= dc - sc; jump++) {
            ArrayList<String> hres = getMazePathWithJumpSmart(sr, sc + jump, dr, dc);
            for (String s : hres) {
                myres.add("h" + jump + s);
            }
        }

        // vertical
        for (int jump = 1; jump <= dr - sr; jump++) {
            ArrayList<String> vres = getMazePathWithJumpSmart(sr + jump, sc, dr, dc);
            for (String s : vres) {
                myres.add("v" + jump + s);
            }
        }
        // diagonal
        for (int jump = 1; jump <= dr - sr && jump <= dc - sc; jump++) {
            ArrayList<String> dres = getMazePathWithJumpSmart(sr + jump, sc + jump, dr, dc);
            for (String s : dres) {
                myres.add("d" + jump + s);
            }
        }
        return myres;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        // System.out.print(getMazePathWithJumpStupid(0, 0, n - 1, m - 1));
        System.out.print(getMazePathWithJumpSmart(0, 0, n - 1, m - 1));
    }
}
