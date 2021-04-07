#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);


    int best = 0, sum = 0;
    int a[10]= {-1,2,4,-3,5,2,-5,2};
    for (int k = 0; k < 9; k++) {
        sum = max(a[k],sum+a[k]);
        best = max(best,sum);
    }
    cout << best << "\n";



    return 0;
}


