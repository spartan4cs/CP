#include<bits/stdc++.h>
using namespace std;

int main(){


	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int n,h,a[2000],sum=0;
	cin>>n>>h;
	for(int i=0;i<n;i++){
		cin>>a[i];
		if(a[i]>h){
			sum+=2;
		}else{
			sum+=1;
		}		
	}
	cout<<sum;
	
	return 0;
}