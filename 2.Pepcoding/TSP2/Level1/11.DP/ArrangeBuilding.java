import java.util.Scanner;

public class ArrangeBuilding {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int oz = 1;
        int o1 = 1;
        for (int i = 2; i <= n; i++) {
            int nz = o1;
            int n1 = oz + o1;

            oz = nz;
            o1 = n1;
        }

        long ans = oz + o1;
        System.out.println(ans * ans);

    }

}
