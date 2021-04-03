/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);

	int n,c=0;
	char a[2],temp[2];
	cin>>n;
	for(int i=0;i<n;i++){
	   cin>>a[0];
	   //if(i==0){temp[0]=a[0];}else
	   if(i!=0 &&temp[0]==a[0]) c++;
	   temp[0]=a[0];
  	   
	}	
	 cout<<c;
	return 0;
}