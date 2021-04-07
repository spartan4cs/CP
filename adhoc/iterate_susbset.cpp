
#include <bits/stdc++.h>
using namespace std;

        vector<int > subset;
void iterate_subset_recursion(int k) {

	if (k == 3) {
// process subset
	//	cout<<"iterate"<<k;
        	for(auto x:subset)
			cout<<x;

		cout<<"\n";
	} else {
		iterate_subset_recursion(k+1);
		subset.push_back(k);
		iterate_subset_recursion(k+1);
		subset.pop_back();
	}
}



void iterate_subset_bit(int n) {

	//this is using bit ops

	for (int i = 0; i < (1<<n); i++) {
		vector<int> subset;
		for (int j = 0; j < n; j++) {
			if (i&(1<<j)) 
				subset.push_back(j);
		}

	for(auto x:subset)
		cout<<x<<"\n";
	
         cout<<"\n";
	}
}

int main()
{
	// search is using recursion
		
	             iterate_subset_recursion(0);
                      
                       iterate_subset_bit(0);
 

        
                     
	return 0;
}
