/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
                
	int count=0;         
	unsigned long long s[5];
	for(int i=0;i<4;i++){
		cin>>s[i];
	}

	for(int i=0;i<=3;i++){
		for (int j=i+1;j<=3;j++){
	        	if(s[i]==s[j]){
	                	count++;
				break;
			}
		}
		
	}	       	
	cout<<count;
	
	return 0;
}