#include <iostream>
#include <vector>

using namespace std;

int a,b,reA, reB;

int main(void){
	cin >> a >> b;
	reA = (a%10)*100 + ((a/10)%10)*10 + (a/100);
	reB = (b%10)*100 + ((b/10)%10)*10 + (b/100);
	if(reA > reB) cout << reA;
	else cout << reB;
}