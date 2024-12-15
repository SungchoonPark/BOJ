#include <iostream>

using namespace std;

int n;
int color[1001][3];
int cost[1001][3];

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	for(int i=0; i<n; i++){
		for(int j=0; j<3; j++){
			cin >> color[i][j];
		}
	}
	
	cost[0][0] = color[0][0];
	cost[0][1] = color[0][1];
	cost[0][2] = color[0][2];
	for(int i=1; i<n; i++){
		cost[i][0] = min(cost[i-1][1], cost[i-1][2]) + color[i][0];
		cost[i][1] = min(cost[i-1][0], cost[i-1][2]) + color[i][1];
		cost[i][2] = min(cost[i-1][0], cost[i-1][1]) + color[i][2];
	} 
	cout << min(min(cost[n-1][0], cost[n-1][1]), cost[n-1][2]);
}