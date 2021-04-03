#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	int n,a[101];
	cin>>n;
	for(int i=0;i<n;i++){
		  cin>>a[i];
	}
		
	sort(a,a+n);
	for(int k=0;k<n;k++){
		cout<<a[k]<<" ";
	}
	return 0;
}