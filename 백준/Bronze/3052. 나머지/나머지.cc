#include <iostream>
using namespace std;

int arr[42], cnt = 0;

int main(void){
	int num;
	for(int i=0; i<10; i++){
		cin >> num;
		arr[num%42] = 1;
	}
	for(int i=0; i<42; i++){
		if(arr[i] == 1){
			cnt++;
		}
	}
	cout << cnt;
}