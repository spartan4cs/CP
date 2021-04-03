#include <bits/stdc++.h>
typedef long long ll;
#define rep(i,a,b) for (int i = a; i <= b; i++)
#define PB push_back
#define MP make_pair
#define SQ(a) (a)*(a)

using namespace std;

int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, x, y, z, xsum(0), ysum(0), zsum(0);
    cin >> n;

    while (n--) {
        cin >> x >> y >> z;
        xsum += x;
        ysum += y;
        zsum += z;

    }

    if (xsum == 0 && ysum == 0 && zsum == 0) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }

    return 0;

}

