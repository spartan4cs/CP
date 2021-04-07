
#include<bits/stdc++.h>
using namespace std;


void subset_sum(vector<int> arr , int size,int sum){
	
	int track=0;
	for(int i=0;i<(1<<size);++i){
		//vector<int> subset1,subset2 ;
		int sum1=0,sum2=0;
		for(int j=0;j<size;++j){
			if(i&(1<<j)){
				//subset1.push_back(arr[j]);
				sum1+=arr[j];
			}
			else{
				//subset2.push_back(arr[j]);
				sum2+=arr[j];
			}			
				
		}
		if(sum1==sum2 && (sum1+sum2==sum)){
			track=1; break;
		}
	}
	if(track==1) cout<<"YES";
	else cout<<"NO";
	                
}

	
int main(){
	
	vector<int> arr;

	int t,a;
	int sum=0;
	cin>>t;
	while(t--){
		cin>>a;
		sum+=a;
		arr.push_back(a);
	}               
	subset_sum(arr,arr.size(),sum);
		
return 0;
}