/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	
	string s;
	cin>>s;
	int count=0;
	for(int i=0;i<s.size();i++){
	    if(s[i]<92) count++; else count--;
	}                
	if(count>0){
	   for(int i=0;i<s.size();i++){
		if(s[i]>92){
			s[i]-=32;
		}

	   }
	}else{
	   for(int i=0;i<s.size();i++){
		if(s[i]<92){
			s[i]+=32;
		}          
	    }
	}
	for(int j=0;j<s.size();j++) cout<<s[j];
	return 0;
}