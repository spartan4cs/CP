
//09.12.2020 00:23:08

// { Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


// User function Template for C++
class Solution{
    public:
    vector<vector<int>> combinationSum(vector<int> &candidates, int n, int target){
        // code here
      vector<vector<int>> result;
        vector<int> curr;
        sort(candidates.begin(), candidates.end()); //because we will ignore duplicate elements
        combination(candidates, target, curr, result, 0);
        return result;
    }
  void combination(vector<int>& candidates, int target, vector<int> curr, vector<vector<int>>& result, int idx) {
        if(idx == camdidates.length()) {
            result.push_back(curr);
            return;
        }
        
      for(int i = idx; i<candidates.size(); i++) {
     //       if(i > idx && candidates[i] == candidates[i-1])
            curr.push_back(candidates[i]);
            combination(candidates,candidates[i], curr, result, i+1);
            curr.pop_back();
        }
                       }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int N, x, B;
        cin>>N;
        vector<int> A;
        for(int i = 0;i < N;i++)
        {
            cin>>x;
            A.push_back(x);
        }
        cin>>B;
        
        Solution ob;
        vector<vector<int>> result;
        result = ob.combinationSum(A, N, B);
        
        if(result.size() == 0)
        cout<<"Empty"<<endl;
        else{
            for(int i = 0;i < result.size(); i++){
                cout<<"(";
                for(int j = 0; j < result[i].size();j++){
                    cout<<result[i][j];
                    if(j < result[i].size() - 1)
                    cout<<" ";
                }
                cout<<")";
            }
            cout<<endl;
        }
    }
    return 0;
}  // } Driver Code Ends