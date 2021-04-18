import java.util.ArrayList;
import java.util.Scanner;

public class kpc {

    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> getKpc(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String rem = str.substring(1);
        ArrayList<String> rres = getKpc(rem);
        ArrayList<String> mres = new ArrayList<>();
        String codeforch = codes[ch - 48];
        for (int i = 0; i < codeforch.length(); i++) {
            char chcode = codeforch.charAt(i);
            for (String s : rres) {
                mres.add(chcode + s);
            }
        }
        return mres;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getKpc(s));
    }
}
