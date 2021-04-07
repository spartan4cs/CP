/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int maximum(int a,int b){ return a>b?a:b;}

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
		
	int a,b;
	cin>>a>>b;
	int m=maximum(a,b);
	if(m==1)	cout <<"1/1";
	else if(m==2) cout<<"5/6";	
	else if(m==3) cout<<"2/3";
	else if(m==4) cout<<"1/2";
	else if(m==5) cout<<"1/3";
	else if(m==6) cout<<"1/6";
	

	return 0;
}