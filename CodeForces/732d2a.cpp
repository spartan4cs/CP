/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int k,r,c=0;
	cin>>k>>r;
	int temp=k;     
	int temp2=k;
	
	//if(temp%10==0 || temp%10 ==r) c++; else{
                                    
	while(1){
	c++;
	if(temp%10==0 )	break;else
	if(temp%10==r)break;else temp=temp2*(c+1);
	
	}
	

	cout<<c;

	return 0;
}