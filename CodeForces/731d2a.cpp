/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	
	string s;
	int sp=97,c=0;
	cin>>s;
	for(int i=0;i<s.size();i++){
		int in=(int)s[i]; 
		int temp = abs(sp-in)%26;                          //97,122,101,117,115
		if(temp%26>13){//clockwise
	
			//prev=123-in;
			c+=26-temp;	
		}else c+=temp;          //anticlockwise
		sp=in;
		
	}	

	cout<<c;

	return 0;
}