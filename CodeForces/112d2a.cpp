#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	string x,y;
	//unsigned long long int x=0,y=0; 
	cin>>x>>y;
	for(int i=0;i<x.length();i++){
		
		
		if(x[i]<92) x[i]+=32;
		if(y[i]<92) y[i]+=32;
			
		
		
	}	  
         
	if(x<y){cout<<"-1";}else if(x>y){cout<<"1";}else if(x==y){cout<<"0";}
		       
	return 0;
}