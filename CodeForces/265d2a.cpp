/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	
	string s1,s2;
	int sq = 0;
	cin>>s1>>s2;
	int s2len = s2.length();
	for(int i=0;i<s2len;i++){
		
		if(s1[sq]==s2[i]){
	          	
			sq++;
		}					
	
	}
	cout<<sq+1;
	

	return 0;
}