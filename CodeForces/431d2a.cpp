/*aakash404*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    	ios::sync_with_stdio(0);

	cin.tie(0);

	long a[6],sum=0;
	string s;
	cin>>a[1]>>a[2]>>a[3]>>a[4];
	cin>>s;
	
	for(int i=0;i<s.size();i++){
	//cout<<	
	sum+=a[s[i]-'0'];	

	}
	cout<<sum;
	return 0;
}