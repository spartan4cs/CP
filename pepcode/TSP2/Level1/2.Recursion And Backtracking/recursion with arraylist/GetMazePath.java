import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePath {

    public static ArrayList<String> getMazePathSmart(int sr, int sc, int dr, int dc) {
        // System.out.println(sr + " " + sc);
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;

        }

        ArrayList<String> myres = new ArrayList<>();

        if (sc <= dc) {

            ArrayList<String> hres = getMazePathStupid(sr, sc + 1, dr, dc);
            for (String h : hres) {
                myres.add("h" + h);
            }
        }

        if (sr <= dr) {
            ArrayList<String> vres = getMazePathStupid(sr + 1, sc, dr, dc);
            for (String v : vres) {
                myres.add("v" + v);
            }
        }

        return myres;
    }

    public static ArrayList<String> getMazePathStupid(int sr, int sc, int dr, int dc) {
        // System.out.println(sr + " " + sc);
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;

        } else if (sr > dr || sc > dc) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> hres = getMazePathStupid(sr, sc + 1, dr, dc);
        ArrayList<String> vres = getMazePathStupid(sr + 1, sc, dr, dc);
        ArrayList<String> myres = new ArrayList<>();

        for (String h : hres) {
            myres.add("h" + h);
        }
        for (String v : vres) {
            myres.add("v" + v);
        }

        return myres;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // smart calls
        System.out.println(getMazePathSmart(0, 0, n - 1, m - 1));
        // stupid calls
        // System.out.println(getMazePathStupid(0, 0, n - 1, m - 1));
    }
}
