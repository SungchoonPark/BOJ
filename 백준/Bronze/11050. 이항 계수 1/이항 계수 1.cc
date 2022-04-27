#include <iostream>

using namespace std;

int N,K,Nnum=1,Knum=1,number,down=1;

int main(void){
	cin >> N >> K;
	number = N - K;
	for(int i=1; i<=N; i++){
		Nnum *= i;
	}
	for(int i=1; i<=K; i++){
		Knum *= i;
	}
	for(int i=1; i<=number; i++){
		down *= i;
	}
	cout << Nnum/(Knum * down);
}