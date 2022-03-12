#include <iostream>

using namespace std;

int main(void){
	bool ascending = true;
	bool descending = true;
	int data[8];
	
	for(int i=0; i<8; i++){
		cin >> data[i];
	}
	for(int i=1; i<8; i++){
		if(data[i-1] > data[i]){
			ascending = false;
		}
		if(data[i-1] < data[i]){
			descending = false;
		}
	}
	
	if(ascending == true){
		cout << "ascending";
	}
	else if(descending == true){
		cout << "descending";
	}
	else{
		cout << "mixed";
	}
}