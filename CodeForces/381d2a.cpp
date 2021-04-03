/*aakash404*/

#include<bits/stdc++.h>
#define max(a,b) ((a>b)?a:b)
using namespace std;

int main(){
    	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int n,a[1001],sc=0,dc=0;
	//cout<<max(10,5);
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>a[i];
	}	
	
	int temp =1,j=0,k=n-1;
	if(n==1){sc=a[0];}
     for(int p=n-1;p>0;p--)
	switch(temp){
		case 1:
			if(a[j]>a[k]) {sc+=a[j++]; if(p==1) dc+=a[j];}else{sc+=a[k--];if(p==1) dc+=a[k];}
			temp=2; break;            

		case 2:
			if(a[j]>a[k]) {dc+=a[j++];if(p==1) sc+=a[j];}else{dc+=a[k--];if(p==1) sc+=a[k];}
			temp=1; break;
	
	}

	cout<<sc<<" "<<dc;

	return 0;
}