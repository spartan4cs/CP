import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths {
    public static ArrayList<String> getStaitPathSmart(int n) {
        System.out.println(n);

        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> paths = new ArrayList<>();

        for (int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
            ArrayList<String> p = getStaitPathSmart(n - jump);
            for (String pString : p) {
                paths.add(jump + pString);
            }

        }
        return paths;
    }

    public static ArrayList<String> getStaitPathStupid(int n) {

        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (n < 0) {
            return new ArrayList<>();
        }
        ArrayList<String> p1 = getStaitPathStupid(n - 1);
        ArrayList<String> p2 = getStaitPathStupid(n - 2);
        ArrayList<String> p3 = getStaitPathStupid(n - 3);
        ArrayList<String> paths = new ArrayList<>();

        for (String p : p1) {
            paths.add(1 + p);
        }
        for (String p : p2) {
            paths.add(2 + p);
        }
        for (String p : p3) {
            paths.add(3 + p);

        }

        return paths;
    }

    // using level option

    public static ArrayList<String> getStairPathLevelOrder(int n) {

        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        if (n < 0) {
            return new ArrayList<>();
        }
        ArrayList<String> mres = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ArrayList<String> rres = getStairPathLevelOrder(n - i);
            for (String s : rres) {
                mres.add(i + s);
            }

        }
        return mres;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // smart call
        System.out.println(getStaitPathSmart(n));
        // stupid call
        System.out.println(getStaitPathStupid(n));
        // leveloption
        System.out.println(getStairPathLevelOrder(n));

    }
}
