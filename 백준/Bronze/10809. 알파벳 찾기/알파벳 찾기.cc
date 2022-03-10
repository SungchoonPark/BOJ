#include <iostream>
using namespace std;

string word;
int arr[26];

int main(void){
	cin >> word;
	int size = word.size();
	
	for(int i=0; i<26; i++){
		arr[i] = -1;
	}
	
	for(int i=0; i<size; i++){
		if(arr[word[i] - 'a'] == -1) arr[word[i] - 'a'] = i;
		else continue;
	}
	for(int i=0; i<26; i++){
		cout << arr[i] << ' ';
	}
} 