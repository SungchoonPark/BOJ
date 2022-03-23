#include <iostream>

using namespace std;

char word[1000001];
int cnt[26] , flag = 1;

int main(void){
	cin >> word;
	for(int i=0; word[i] != '\0'; i++){
		if(word[i] >= 'a' && word[i] <= 'z') word[i] -= 32;
		cnt[word[i] - 'A']++;
	}
	int max = 0;
	int maxIndex = 0;
	for(int i=0; i<26; i++){
		if(cnt[i] > max){
			maxIndex = i;
			max = cnt[i];
		}
	}
	for(int i=maxIndex+1; i<26; i++){
		if(cnt[i] == cnt[maxIndex]){
			flag = 0;
			break;
		}
	}
	if(flag == 0) cout << '?';
	else cout << (char)(maxIndex + 'A');
}