
#include <bits/stdc++.h>
using namespace std;


void permutate_iteration(int n) {

vector<int> permutation;
for (int i = 0; i < n; i++) {
	permutation.push_back(i);	
}
do {
// process permutation

	for(auto x:permutation)
		cout<<x;
	
         cout<<"\n";


} while (next_permutation(permutation.begin(),permutation.end()));

	
}





int main()
{
	// search is using recursion
		
 	 permutate_iteration(3);    
   
                     
	return 0;
}
