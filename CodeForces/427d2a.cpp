/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	
	unsigned long long int n,x;
	int c=0,d=0;
	cin>>n;
	while(n--){
		
		cin>>x;
		c+=x;
		if(c<0) {d++;c=0;}

	}	
	cout<<d;

	return 0;
}