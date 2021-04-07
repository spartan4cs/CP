#include<bits/stdc++.h>
using namespace std;

        class graph{
		int v;
		list<int> *adj;
        public:
		graph(int v);
		void addEdge(int n,int m );
		void bfs(int s);
		
        };
	graph::graph(int v){
	 	this->v=v;
		adj = new list<int>[v];
	}
	void graph::addEdge(int n,int m){
		adj[n].push_back(m);
	}
	void graph::bfs(int s){
		
		bool *visited  = new bool[v];
		for(int i=0;i<v;i++){
			visited[i]=false;	           	
		}
		list<int> queue;
		queue.push_back(s);
		visited[s]=true;
		list<int >::iterator i;
		while(!queue.empty()){
	
			s=queue.front();
			cout<<s;
			queue.pop_front();
			for(i =adj[s].begin();i!=adj[s].end();++i){
				if(!visited[*i]){
	
					visited[*i]=true;
					queue.push_back(*i);		                	                               	
	
				}       
			}
			
			
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
	g.bfs(2);


return 0;
}