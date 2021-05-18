import java.io.*;
import java.util.*;

class Leet_longest_string_chain {

	public static String getStringOfMaxLength(String[] words) {
		String max = "";
		for (String word : words) {
			if (word.length() > max.length()) {
				max = word;
			}
		}
		return max;
	}

	public static List<String> getPermutaionOfword(String word, String asf, List<String> ans) {

		if (word.length() == 0) {
			ans.add(asf);
			// System.out.println("asf- permutation --> " + asf);
			return ans;
		}

		for (int i = 0; i < word.length(); i++) {
			ans = getPermutaionOfword(word.substring(0, i) + word.substring(i + 1), asf + word.charAt(i), ans);

		}
		return ans;
	}

	public static boolean wordContainString(String str, String[] words) {
		// List<String> ans = new ArrayList();
		// List<String> list = getPermutaionOfword("", "", ans);
		// System.out.println(list);

		for (String word : words) {

			if (str.equals(word))
				return true;

		}
		return false;
	}

	// get string of max length
	// iterate through each char in that string as option and pass the remaining
	// string as substring to next level and check if that substring is present in
	// words array

	public static int helper_fun(String[] words, String str, int count, String asf, HashMap<String, Integer> storage) {
		// if substring is not present in word arr then return 0;
		if (wordContainString(str, words) == false) {
			System.out.println("ans so far-->  " + asf + " count so far--> " + count);
			return count;
		}

		// if same string comes then fetch from the storage
		if (storage.containsKey(str)) {
			return storage.get(str);
		}

		int ans = 0;

		for (int i = 0; i < str.length(); i++) { // options bdca at 0th level
			// call only if substring is present in word arr
			if (wordContainString(str, words) == true) {
				// next level as remaining string
				int c = helper_fun(words, str.substring(0, i) + str.substring(i + 1), count + 1, asf + str.charAt(i),
						storage);
				// lets say ba is present in string
				// then store the value of count in that string
				storage.put(str, c);

				// get the max value of all the iteration count
				ans = Math.max(ans, c);

			}

		}

		return ans;
	}

	public static int longest_string_chain(String[] words) {
		String str = getStringOfMaxLength(words);
		HashMap<String, Integer> store = new HashMap<>();
		int count = helper_fun(words, str, 0, "", store);

		return count;
	}

	public static void main(String args[]) {
		String[] words = { "a", "b", "ab", "bac" };
		System.out.println(longest_string_chain(words));
	}
}