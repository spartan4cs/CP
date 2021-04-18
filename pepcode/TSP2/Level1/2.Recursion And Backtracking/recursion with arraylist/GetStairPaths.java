import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths {
    public static ArrayList<String> getStaitPath(int n) {

        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (n < 0) {
            return new ArrayList<>();
        }
        ArrayList<String> p1 = getStaitPath(n - 1);
        ArrayList<String> p2 = getStaitPath(n - 2);
        ArrayList<String> p3 = getStaitPath(n - 3);
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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getStaitPath(n));
    }
}
