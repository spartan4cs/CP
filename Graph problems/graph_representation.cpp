#include<bits/stdc++.h>
using namespace std;

		
void addEdge(vector<int> adj[] , int i, int j){
	adj[i].push_back(j);
	adj[j].push_back(i);
}

void printGraph(vector<int> adj[] ,int v){
	
	for(int i=0;i<v;i++){
		cout<<"index: "<<i;
		for(auto j:adj[i])
		      cout<<"-->"<<j;
		cout<<"\n";
	}
}

int main(){                  	
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int v=5;   
 vector<int> adj[v]; 
    addEdge(adj, 0, 1); 
    addEdge(adj, 0, 4); 
    addEdge(adj, 1, 2); 
    addEdge(adj, 1, 3); 
    addEdge(adj, 1, 4); 
    addEdge(adj, 2, 3); 
    addEdge(adj, 3, 4); 
    printGraph(adj, v);
	return 0;	
}