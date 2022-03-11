#include <iostream>

using namespace std;

int testNum, sum = 0, count=1;
string ox;

int main(void){
	cin >> testNum;
	for(int i=0; i<=testNum-1; i++){
		cin >> ox;
		for(int j=0; j<ox.length(); j++){
			if(ox[j] == 'O'){
				sum += count;
				count++;
			}
			if(ox[j] == 'X'){
				count = 1;
			}
		}
		cout << sum << "\n";
		count = 1;
		sum = 0;
	}
}