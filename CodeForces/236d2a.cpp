/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);

	string 	s;
	cin>>s;
	int hval[35]={0},count=0;
	for(int i=0;i<s.size();i++){
		
		hval[s[i]%34]+=1;
		count++;
		if(hval[s[i]%34]>1){
		  hval[s[i]%34]-=1;
		  count--;
		}
	}	
	if(count%2==0) cout<<"CHAT WITH HER!"; else cout<<"IGNORE HIM!";
	                          
	return 0;
}