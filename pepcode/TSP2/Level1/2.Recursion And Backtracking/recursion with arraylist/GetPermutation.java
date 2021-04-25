import java.util.ArrayList;

public class GetPermutation {

    public static ArrayList<String> permutate(String str) {

        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> mres = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {

            char first = str.charAt(i);
            String rem = str.substring(0, i) + str.substring(i + 1);
            ArrayList<String> rres = permutate(rem);
            for (String s : rres) {
                mres.add(first + s);
            }
        }

        return mres;

    }

    public static void main(String[] args) {

        String str = "abc";
        System.out.println(permutate(str));
    }
}
