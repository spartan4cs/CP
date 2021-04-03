#include <iostream>   
#include <sstream>   
#include <cstdio>   
#include <cstdlib>   
#include <cmath>   
#include <memory.h>   
#include <cctype>   
#include <string>   
#include <vector>   
#include <list>   
#include <queue>   
#include <deque>   
#include <stack>   
#include <map>   
#include <set>   
#include <algorithm>   
using namespace std;  
   
#define FOR(i,a,b) for(int (i) = (a); (i) < (b); ++(i))  
#define RFOR(i,a,b) for(int (i) = (a)-1; (i) >= (b); --(i))  
#define CLEAR(a) memset((a),0,sizeof(a))  
#define INF 1000000000
#define PB push_back  
#define ALL(c) (c).begin(), (c).end()  
#define pi 2*acos(0.0)  
#define SQR(a) (a)*(a)  
#define MP make_pair  
#define MAX 128
   
typedef long long Int;  
 
int n, c;
int A[MAX];
 
 
int main()
{
	
	int T;
	cin >> T;
	FOR (t,0,T)
	{
		cin >> n >> c;
		int sum = 0;
		FOR (i,0,n)
		{
			int a;
			scanf("%d", &a);
			sum += a;
		}
 
		if (sum <= c)
			cout << "Yes" << endl;
		else
			cout << "No" << endl;
	}
 
 
	return 0;
} 
  
