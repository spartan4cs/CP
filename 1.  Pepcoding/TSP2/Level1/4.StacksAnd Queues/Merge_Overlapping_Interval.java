import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Merge_Overlapping_Interval {

    public static class Pair implements Comparable<Pair> {
        int st;
        int end;

        public Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }

        public int compareTo(Pair p) {
            return this.st - p.st;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        List<Pair> pl = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            pl.add(new Pair(arr[i][0], arr[i][1]));
        }
        // pl.forEach(p -> System.out.println(p.st + " " + p.end));

        Collections.sort(pl);
        Stack<Pair> st = new Stack<>();
        st.push(pl.get(0));
        for (int i = 1; i < pl.size(); i++) {
            if (pl.get(i).st <= st.peek().end) {
                st.peek().setEnd(Math.max(pl.get(i).end, st.peek().end));
            } else {
                st.push(pl.get(i));
            }
        }

        // System.out.println(st.size());
        Stack<Pair> st2 = new Stack<>();

        while (!st.empty()) {
            st2.push(st.pop());
        }
        while (!st2.empty()) {
            System.out.println(st2.peek().st + " " + st2.peek().end);
            st2.pop();
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

}