#include <iostream>

using namespace std;

int main() {

	int t, r;
	char s[20];
	cin >> t;

	for (int i = 0; i < t; i++) {
		
		cin >> r >> s;

		for (int j = 0; s[j] != '\0'; j++) {
			for (int k = 0; k < r; k++)
				cout << s[j];
		}
		cout << "\n";
	}
	return 0;
}
