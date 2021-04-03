/**
 * June 2012 Codechef Long Contest
 *
 * Problem:     LECANDY
 * Author:      Anton Lunyov (Tester)
 * Complexity:  O(T * N)
 * Timing:      0.36 out of 2
 */

#include <iostream>
using namespace std;

int main() {
	int T;
	cin >> T;
	for (int t = 0; t < T; ++t) {
		int N, C;
		cin >> N >> C;
		for (int i = 0; i < N; ++i) {
			int Ai;
			cin >> Ai;
			C -= Ai;
		}
		cout << (C < 0 ? "No" : "Yes") << endl;
	}
	return 0;
}
