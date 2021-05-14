import java.util.Stack;

public class Leet_Remove_All_Adjacent_Duplicates_in_String_II {

    /**
     * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
     */

    // TLE- Naive recursive solution
    public static String removeDuplicates_Recursive(String s, int k) {

        int count = 1;
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count == k)
                s = removeDuplicates_Recursive(s.substring(0, i - k + 1) + s.substring(i + 1), k);

        }
        return s;
    }

    // abbbcdvvvdd
    // 0123456789
    // ^
    // i=1
    // stack 0 1
    // sc = a c d

    // same element at i and i-1 then continue i++j++
    // different element ar i and i-1 the push index

    public static String removeDuplicates_Stack(String S, int K) {
        char[] SC = S.toCharArray();
        int i, j;
        Stack<Integer> st = new Stack<>();
        st.add(0);
        for (i = 1, j = 1; j < S.length(); i++, j++) {
            char currentelement = SC[j];
            SC[i] = SC[j]; // updaing 1st occurence in sc
            if (i == 0 || currentelement != SC[i - 1])
                st.add(i); // added first occurence index
            else if (i - st.peek() + 1 == K) { // when i reaches kthe occurence then update i with 1st occurence -1
                i = st.pop() - 1; // -1 because next step is i++ for adding new 1st occurence

            }
        }
        return new String(SC, 0, i);
    }

    public static void main(String[] args) {

        String str = "abbbcdvvvdd";
        System.out.println(removeDuplicates_Recursive(str, 3));
        System.out.println(removeDuplicates_Stack(str, 3));

    }
}
