#include <iostream>
using namespace std;

int A,B,C;
int arr[10];
int main(void){
	cin >> A >> B >> C;
	int res = A*B*C;
	while(1){
		int tmp = res%10;
		arr[tmp]++;
		res /= 10;
		if(res == 0){
			break;
		}
	}
	for(int i=0; i<10; i++){
		cout << arr[i] << "\n";
	}
}