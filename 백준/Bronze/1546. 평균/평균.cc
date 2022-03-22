#include <iostream>
#include <algorithm>
using namespace std;

int M,num;
double a[1001],sum = 0.0;

int main(void){
	cin >> num;
	for(int i=0; i<num; i++){
		cin >> a[i];	
	}
	sort(a,a+num);
	M = a[num-1];
	for(int i=0; i<num; i++){
		a[i] = (a[i]/(double)M)*100;
		sum += a[i];
	}
	cout << (double)(sum / (double)num);
}