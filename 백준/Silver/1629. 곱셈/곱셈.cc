#include <iostream>
#include <cmath>
using namespace std;

long long A,B,C;

long long result(int a, int b, int c){
	if(b == 0) return 1;
	long long temp = result(a,b/2,c);
	temp = temp*temp%c;
	if(b%2==0) return temp;
	else return temp*a%c;
}

int main(void){
	cin >> A >> B >> C;
	cout << result(A,B,C);
}