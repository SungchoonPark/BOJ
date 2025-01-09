#include <stdio.h>

int main() {
    int t; // 테스트 케이스의 개수
    scanf("%d", &t);

    while (t--) {
        int a, b;
        scanf("%d %d", &a, &b);

        // 컴퓨터 번호 계산
        int computer = 1;
        for (int i = 0; i < b; i++) {
            computer = (computer * a) % 10;
        }

        // 컴퓨터 번호가 0인 경우 10번 컴퓨터
        if (computer == 0) {
            computer = 10;
        }

        printf("%d\n", computer);
    }

    return 0;
}