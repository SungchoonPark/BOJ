#include <iostream>

using namespace std;

int one, two, a, b, c;

int main(void){
	cin >> one >> two;
	a = one;
	b = two;
	while(true){
		c = a % b;
		if(c == 0) break;
		a = b;
		b = c;
	}
	cout << b << "\n" << one*two/b ;
}