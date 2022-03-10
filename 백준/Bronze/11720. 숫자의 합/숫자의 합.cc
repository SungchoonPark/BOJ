#include <iostream>

using namespace std;

int n, sum=0;
string number;
int main(void){
	cin >> n;
	cin >> number;
	
	for(int i=0; i<number.size(); i++){
		sum += number[i] - '0';
	}
	
	cout << sum;
	
	return 0;
}