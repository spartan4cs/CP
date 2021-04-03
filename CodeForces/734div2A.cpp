#include<bits/stdc++.h>
using namespace std;

int main(){


	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int n,ca=0,cd=0;
	string s;
	cin>>n>>s;
	for(int i=0;i<s.length();i++){
		if(s[i]=='D'){
			cd++;
			
		}else if(s[i]=='A'){
			ca++;
		}
		

		
	}

	if(ca>cd){
		cout<<"Anton";

	}else if(cd>ca){
	        cout<<"Danik";
	}else{
	       cout<<"Friendship";
	}	
	return 0;
}