/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);

	unsigned long long s[5],count=0;
	for(int i=0;i<4;i++){
	
		cin>>s[i];
	}	

	
		if(s[0]==s[1]) count++;if(s[0]==s[2]) count++;
if(s[0]==s[3]) count++;if(s[1]==s[2] && count!=3) count++;
if(s[1]==s[3] && count !=3) count++;if(s[2]==s[3] &&count!=3) count++;
	

	cout<<count;


	return 0;
}