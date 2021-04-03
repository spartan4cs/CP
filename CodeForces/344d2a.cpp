/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	int t,x,temp=0,c=0;
	cin>>t;
	while(t--){
	   cin>>x;
	   if(temp!=0 && x!=temp ) c++;

	   temp=x;
		
	}	
	cout<<c+1;

	return 0;
}