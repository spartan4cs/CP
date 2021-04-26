import java.util.Scanner;

public class CountHi {

    public static void getCountHISir(String s) {

        int n = s.length();
        int i = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (i < n) {
            char ch = s.charAt(i);
            char nch = s.charAt(i + 1);
            if (i < n - 1 && ch == 'h' && nch == 'i') {
                count++;
                i = i + 2;
                continue;
            }
            sb.append(ch);
            i++;
        }
        System.out.println(count);
        System.out.println(sb.toString());

    }

    public static int getCountHI(String s) {

        int n = s.length();
        int i = 0;
        int count = 0;
        while (i < n - 1) {
            char ch = s.charAt(i);
            char nch = s.charAt(i + 1);
            if (ch == 'h' && nch == 'i') {
                count++;
            }
            i++;
        }
        return count;
    }

    public static void removeHi(String s) {
        int n = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i <= n - 1) {
            char ch = s.charAt(i);

            char nch = (i < n - 1) ? s.charAt(i + 1) : 0;

            if (ch == 'h' && nch == 'i') {
                i++;
            } else {
                sb.append(ch);
            }
            i++;
        }
        System.out.println(sb.toString());
    }

    public static int getCountHiNotHit(String s) {

        int n = s.length();
        int i = 0;
        int count = 0;
        while (i < n - 2) {
            char ch = s.charAt(i);
            char nch = s.charAt(i + 1);
            char nnch = s.charAt(i + 2);
            if (ch == 'h' && nch == 'i' && nnch == 't') {

            } else if (ch == 'h' && nch == 'i') {
                count++;
            }
            i++;
        }
        // to add the last hi
        if (s.charAt(n - 2) == 'h' && s.charAt(n - 1) == 'i')
            count++;
        return count;
    }

    public static void removeHiNotHit(String s) {

        int n = s.length();
        int i = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (i <= n - 1) {
            char ch = s.charAt(i);
            char nch = (i < n - 2) ? s.charAt(i + 1) : 0;
            char nnch = (i < n - 2) ? s.charAt(i + 2) : 0;
            if (ch == 'h' && nch == 'i' && nnch == 't') {
                sb.append(ch);
            } else if (ch == 'h' && nch == 'i') {
                i++;
            } else {
                sb.append(ch);
            }
            // remove last
            i++;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        String s = "ighihithithihihithi";
        // System.out.println(getCountHI(s));
        getCountHISir(s);

        // removeHi(s);
        // System.out.println(getCountHiNotHit(s));
        // removeHiNotHit(s);

    }
}
