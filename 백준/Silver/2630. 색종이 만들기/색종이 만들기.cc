#include <iostream>
using namespace std;
int arr[128][128];
int blue = 0;
int white = 0;

int checkBox(int x_start, int y_start, int len) {
	int total = 0;
	for (int i = 0; i < len; i++) {
		for (int j = 0; j < len; j++) {
			total += arr[x_start + i][y_start + j];
		}
	}
	if (total == len * len) { //블루카드로만 있을때 ㅇㅇ! 
		return 1;
	} else if (total == 0) { //하얀 카드만 있을때 ㅇㅇ! 
		return 0; 
	} else { //블루랑 화이트만 있는거. 
		return -1;
	}
}

void divisionBox(int x_start, int y_start, int len) {
	int x[4] = {0, 0, 1, 1};
	int y[4] = {0, 1, 0, 1};
	for (int i = 0; i < 4; i++) {
		int a = x_start + x[i] * len;
		int b = y_start + y[i] * len;
		int result = checkBox(a, b, len);
		if (result == 0) {
			white++;
		} else if (result == 1) {
			blue++;
		} else {
			divisionBox(a, b, len/2);
		}
	} 
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
    int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}
	int result = checkBox(0, 0, N);
	if (result == 0) {
		white++;
	} else if (result == 1) {
		blue++;
	} else {
		divisionBox(0, 0, N/2);
	}
	cout << white << "\n" << blue;
}