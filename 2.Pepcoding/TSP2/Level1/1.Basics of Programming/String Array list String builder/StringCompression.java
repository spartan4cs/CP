import java.util.Scanner;

public class StringCompression {

    public static void compression1(String str) {

        int i = 0;
        int j = 1;
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        if (n > 1) {
            while (j <= n) {
                if (j == n) {
                    System.out.println(sb.append(str.charAt(i)).toString());
                    return;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    j++;
                } else {
                    sb.append(str.charAt(i));
                    i = j;
                    j = j + 1;
                }
            }
        } else {
            System.out.println(sb.append(str).toString());
        }

    }

    public static void compression2(String str) {
        int i = 0;
        int j = 1;
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        if (n > 1) {
            int count = 1;
            while (j <= n) {
                if (j == n) {
                    String a = (count == 1) ? sb.append(str.charAt(i)).toString()
                            : sb.append(str.charAt(i)).append(count).toString();
                    System.out.println(a);

                    return;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    j++;
                    count++;
                } else {
                    sb.append(str.charAt(i));
                    sb = count == 1 ? sb : sb.append(count);
                    count = 1;
                    i = j;
                    j = j + 1;
                }
            }
        } else {
            System.out.println(sb.append(str).toString());
        }

    }

    public static void main(String[] args) {
        // compression1("wwwwaaadexxxxxx");
        // compression2("wwwwaaadexxxxxx");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        compression1(str);
        compression2(str);
    }
}
