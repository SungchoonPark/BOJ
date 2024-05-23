#include <iostream>
#include <queue>
using namespace std;

const int MAX = 100001;
int n, k;
int visit[MAX];
queue<pair<int, int>> q;

int bfs(){
    visit[n] = 1;
    q.push({n, 0});
    while(!q.empty()){
        int position = q.front().first;
        int time = q.front().second;
        if(position == k) return time;
        q.pop();
        int dir[3] = {position+1, position-1, position*2};
        for(int i=0; i<3; i++){
            int np = dir[i];
            if(np >= 0 && np < MAX && visit[np]==0){
                q.push({np, time+1});
                visit[np] = 1;
            }
        }
    }
}

int main()
{
    cin >> n >> k;
    cout << bfs();
    return 0;
}