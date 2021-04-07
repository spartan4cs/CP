

#include<bits/stdc++.h>
using namespace std;


class graph{
	
	int v;
	list<int> *adj;
public:
	graph(int v);
	void addEdge(int n,int m );
	void dfsUtil(int s , bool visited[]);
	void dfs();
};

	graph::graph(int v){
		this->v = v;
		adj = new list<int>[v];
	}
	void graph::addEdge(int n , int m){
	
		adj[n].push_back(m);
	}
	void graph::dfsUtil(int s, bool visited[]) {
	
		visited[s]=true; 	
		cout<<s;
		list<int> ::iterator i;
		for(i = adj[s].begin();i!=adj[s].end();++i){
			                                   	
			if(!visited[*i])
				dfsUtil(*i,visited);
		}
	
	}       	
	
	void graph::dfs(){
	                     	
		bool *visited = new bool[v];
		for(int i=0;i<v;i++){
			visited[i]=false;	
		}
		//this for loop is for considerinf disconnected graph
		for(int i=0;i<v;i++){
		        if(!visited[i])
			dfsUtil(i,visited);	
		}	



	}
	


int main(){
	
	graph g(4);
  g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
	g.dfs();
	

return 0;
}