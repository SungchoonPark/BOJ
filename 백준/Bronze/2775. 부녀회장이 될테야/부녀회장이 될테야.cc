#include <iostream>

using namespace std;

int testNum, n, k, arr[15][15];

int main(void){
	int sum = 0;
	cin >> testNum;
	for(int i=0; i<15; i++){
		for(int j=1; j<15; j++){
			if(i==0){
				arr[i][j] = j; 
			}
			else{
				for(int k=1; k<=j; k++){
					sum += arr[i-1][k];
				}
				arr[i][j] = sum;
				sum = 0;
			}
		}
	}
	for(int i=0; i<testNum; i++){
		cin >> k;
		cin >> n;
		cout << arr[k][n] << "\n";
	}
}