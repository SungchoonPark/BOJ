class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] numbers = {4, 1, 2};  // 0, 1, 2 나머지에 대응하는 숫자

        while (n > 0) {
            int remainder = n % 3;
            n /= 3;

            if (remainder == 0) n--;  // 나머지가 0일 경우, n을 하나 줄여야 함

            answer.insert(0, numbers[remainder]);  // 결과의 앞에 숫자를 삽입
        }

        return answer.toString();
    }
}