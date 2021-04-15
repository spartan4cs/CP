import java.util.Scanner;

import javax.management.monitor.CounterMonitor;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stars = 1;
        int spaces = n / 2;
        int counter = 1;
        int start_counter = 1;
        for (int i = 0; i < n; i++) {
            // System.out.print(counter + " " + stars + " " + spaces);
            for (int j = 0; j < spaces; j++) {
                System.out.print("\t");
            }

            for (int j2 = 0; j2 < stars; j2++) {
                // System.out.print("*\t");
                System.out.print(start_counter + "\t");
                // maintian counter within stars loop
                if (j2 < stars / 2) {
                    start_counter++;
                } else {
                    start_counter--;
                }
            }
            // update stars and spaces
            // update start of counter
            if (i < n / 2) {
                stars += 2;
                spaces--;
                counter++;

            } else {
                spaces++;
                stars -= 2;
                counter--;

            }
            start_counter = counter;
            System.out.println();
        }
    }
}
