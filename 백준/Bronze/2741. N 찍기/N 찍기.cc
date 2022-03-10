#include <iostream>

using namespace std;

int num;

int main(void){
	cin >> num;
	for(int i=1; i<=num; i++){
		if(i==num) cout << i;
		else cout << i << "\n";
	}
}