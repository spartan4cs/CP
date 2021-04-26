import java.util.ArrayList;

class GetSubsequence {
    public static void main(String[] args) throws Exception {

        ArrayList<String> a = gss("abc");
        // for (int i=0;i<a.size();i++) {
        System.out.print(a);
        // }
    }

    // public static ArrayList<String> gss(String str) {

    // if (str.length() == 0) {
    // ArrayList res = new ArrayList<>();
    // res.add("");
    // return res;
    // }

    // String first = str.substring(0, 1);
    // String rem = str.substring(1);
    //
    // ArrayList<String> arr = gss(rem);
    // int n = arr.size();
    // int i = 0;
    // manipulating exisint al
    // while (i < n) {
    // arr.add(first.concat(arr.get(i)));
    // i++;
    // }
    // return arr;
    // }

    public static ArrayList<String> gss(String str) {

        if (str.length() == 0) {
            ArrayList res = new ArrayList<>();
            res.add("");
            return res;
        }

        String first = str.substring(0, 1);
        String rem = str.substring(1);
        ArrayList<String> arr = gss(rem);

        // created new AL everytime
        ArrayList<String> mres = new ArrayList<>();
        for (String s : arr) {
            mres.add("" + s);
            mres.add(first + s);
        }

        return mres;
    }

}