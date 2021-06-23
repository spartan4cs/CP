
#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
using namespace __gnu_pbds;
using namespace std;

#define fi first
#define se second
#define ll long long
#define pb push_back
#define mp make_pair
#define pii pair<int, int>
#define vi vector<int>
#define mii map<int, int>
#define pqb priority_queue<int>
#define pqs priority_queue<int, vi, greater<int>>
#define setbits(x) __builtin_popcountll(x)
#define zrobits(x) __builtin_ctzll(x)
#define mod 1000000007
#define inf 1e9
#define ps(x, y) fixed << setprecision(y) << x
#define mk(arr, n, type) type *arr = new type[n];
#define w(x)  \
    int x;    \
    cin >> x; \
    while (x--)
#define FIO                       \
    ios_base::sync_with_stdio(0); \
    cin.tie(0);                   \
    cout.tie(0)
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());

typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> pbds;

const int N = 2e5 + 5;

int n, m;

pair<int, int> vis[1505][1505];

vector<string> v(1505);

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
char darr[] = {'t', 'r', 'l', 'd'};

void dfs(int x, int y)
{
    cout << x << " " << y << endl;
    pair<int, int> p1 = {x, y};

    ll x1 = ((x % n) + n) % n;
    ll y1 = ((y % m) + m) % m;

    if (vis[x1][y1] == p1)
    {
        return;
    }
    pair<int, int> p = {inf, inf};
    if (vis[x1][y1] != p)
    {
        cout << vis[x1][y1].fi << " " << vis[x1][y1].se << " " << x << " " << y << endl;
        cout << "Yes";
        exit(0);
    }
    vis[x1][y1] = p1;

    for (ll i = 0; i < 4; i++)
    {
        x1 = x + dx[i];
        y1 = y + dy[i];
        x1 = ((x1 % n) + n) % n;
        y1 = ((y1 % m) + m) % m;

        if (v[x1][y1] != '#')
        {
            cout << darr[i];
            dfs(x + dx[i], y + dy[i]);
        }
    }
}

int main()
{
    FIO;

    cin >> n >> m;

    int posx = -1, posy = -1;
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (v[i][j] == 'S')
            {
                posx = i;
                posy = j;
            }
            vis[i][j] = {inf, inf};
        }
    }

    dfs(posx, posy);
    cout << "No";
}
