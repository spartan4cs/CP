#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int x,y,z,t,c=0;
	cin>>t;
	while(t--){
		
		cin>>x>>y>>z;
		if(x&y==1 || y&z==1 || z&x ==1)
		   c++;	
		
	}	
	cout<<c;

	return 0;
}