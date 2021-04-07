
#include<bits/stdc++.h>
using namespace std;


void subset_sum(vector<int> arr , int size,int sumation){
	
	for(int i=0;i<(1<<size);i++){
		vector<int> subset;		
		for(int j=0;j<size;j++)
			if(i&(1<<j))
				subset.push_back(arr[j]);

	
		int sum=0;
		for(auto k : subset)
		        sum+=k;
		//cout<<sum;
	 	if(sum==sumation){
			cout<<"true";
			break;
		}	
	 		
	}

	                
}

	
int main(){
	
	vector<int> arr;

	int t,a,sum;
	cin>>t>>sum;
	while(t--){
		cin>>a;
		arr.push_back(a);
	}

 	
 //	arr.push_back(2);
 //	arr.push_back(3);
 //	arr.push_back(1);
 //	arr.push_back(1);
	
	subset_sum(arr,arr.size(),sum);
	/*if(subset_sum(arr , arr.size()))
		cout<<"true";
	else
		cout<<"false";	
	*/
 	
	

return 0;
}