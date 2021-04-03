/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int n,c=0,temp;
	int h[101],g[101];	
	
	cin>>n;
	//temp=n;
	for(int i=0;i<n;i++){
		cin>>h[i]>>g[i];	
	
	}
	for(int j=0;j<n;j++){ 
	temp=n-1;       
	   while(temp>j){
		if(h[j]==g[temp]) c++;
		if(h[temp]==g[j]) c++;
		//cout<<c;
		temp--;
	  }	
	}        

	cout<<c;    	
	
	return 0;
}