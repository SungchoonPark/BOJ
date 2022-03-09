#include <iostream>
#include <string> 
using namespace std;

int main(void){
	int count = 0;
	string arr;
	getline(cin, arr);
	
	for(int i=1; i<arr.size(); i++){
		if(arr[i] == ' '){
			count ++;
		}
	}
	if(arr.back() == ' ') cout << count;
	else cout << count + 1;
} 