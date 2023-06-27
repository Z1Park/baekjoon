#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>
#include <cstring>
#include <string>
#include <queue>
using namespace std;

vector<string> vs;
int chk[100][150];
int chk2[100][150];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    cin>>T;
    while(T--){
        memset(chk,0,sizeof(chk));
        memset(chk2,0,sizeof(chk2));
        vs.clear();
        
        //ok idx
        vector<int> ok;
        
        int n;
        cin>>n;
        string str;
        for(int i=0;i<n;i++){
            cin>>str;
            vs.push_back(str);
        }
        string correct;
        cin>>correct;
        string target;
        cin>>target;
        
        for(int i=0;i<n;i++){
            int flag=0;
            int cnt=0;
            for(int j=0;j<correct.size();j++){
                if(vs[i].size() != correct.size()){
                    flag=1;
                    break;
                }
                
                if(chk[i][vs[i][j]]==0 && chk2[i][correct[j]]==0){
                    chk[i][vs[i][j]]=correct[j];
                    chk2[i][correct[j]]=vs[i][j];
                    cnt++;
                }else if(chk2[i][correct[j]]!=vs[i][j] || chk[i][vs[i][j]]!=correct[j]){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                ok.push_back(i);
                //25개알면 나머지 하나 계산가능
                if(cnt==25){
                    int a=0,b=0;
                    for(int j=97;j<=122;j++){
                        if(chk[i][j]==0){
                            a=j;
                        }
                        if(chk2[i][j]==0){
                            b=j;
                        }
                    }
                    chk[i][a]=b;
                    chk2[i][b]=a;
                }
            }
        }
        
        if(ok.size()==0){
            cout<<"IMPOSSIBLE"<<'\n';
        }else{
            //target해독후 출력
            if(ok.size()==1){
                int idx = ok[0];
                string ans;
                for(int i=0;i<target.size();i++){
                    if(chk[idx][target[i]]==0){
                        ans.push_back('?');
                    }else{
                        ans.push_back(chk[idx][target[i]]);
                    }
                }
                cout<<ans<<'\n';
            }
            else{
                string ans;
                for(int i=0;i<target.size();i++){
                    int flag=0;
                    int idx=ok[0];
                    if(chk[idx][target[i]]==0){
                        ans.push_back('?');
                        continue;
                    }
                    int num = chk[idx][target[i]];
                    for(int j=1;j<ok.size();j++){
                        if(num!=chk[ok[j]][target[i]]){
                            flag=1;
                            break;
                        }
                    }
                    if(flag){
                        ans.push_back('?');
                    }else{
                        ans.push_back(num);
                    }
                }
                cout<<ans<<'\n';
            }
        }
    }
    return 0;
}