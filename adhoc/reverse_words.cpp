#include<bits/stdc++.h>
using namespace std;


void reverse_word(string s){

	
	stack<string> stk;
	int h=0,l=0;
	for(int i=0;i<s.length();i++){
		if(s[i]=='.'){
	        	
			stk.push(s.substr(l,h+1-l));
			h=l=i+1;
		}else h=i;	

		
		
	}
	stk.push(s.substr(l));
	s.clear();
	while(!stk.empty()){
		s.append(stk.top()).append(".");
		stk.pop();
	}
	s.erase(prev(s.end()));
	cout<<s;


	
}

bool ispar(string x)
{
    
    
      map<char,char> check;
        check['{'] ='}';
        check['['] =']';
        check['('] =')';
//                    cout<<check['{'];
    stack<char> c;    
 
    int len = x.length();
    //cout<<len;
        if(len%2==0){
            for(int i=0;i<len;i++){

               // cout<<check[x[i]];
		char b= check[x[i]];
                if(b)         
                    c.push(b);

	
                else if(c.top()==b) {
                cout<<c.top();   
		 c.pop();
                }

                  /*
                else if(c.top()==b) {
                    c.pop();
                }
                else if((c.top())!=b) {
                    cout<<x[i];
                    cout<<c.top();
                    return false;
                }   */
               
            }
            if(c.empty())
                return true;
    }else
        return false;
}
	
int main(){
        ios::sync_with_stdio(0);
	cin.tie(0);
	
//	reverse_word("this.is.awesome");
                          
	string t;
	cin>>t;
	if(ispar(t)){
	cout<<"bal";
}                   else cout<<"ubal";

return 0;
}