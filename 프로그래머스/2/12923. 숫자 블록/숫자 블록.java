import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int size = (int) (end - begin + 1);
        int[] answer = new int[size];
        int b = (int) begin;
        int e = (int) end;
        Arrays.fill(answer, 1);
        
        int idx = 0;
        for (int i = b; i <= e; i++) {
            answer[idx++] = getMaxDivisor(i);
        }
        
        if(b == 1) answer[0] = 0;
        
        return answer;
    }

    // i보다 작은 약수 중 가장 큰 값을 구함 (단 1 제외, 최대 1천만 이하)
    private int getMaxDivisor(int n) {
        if (n == 1) return 0;

        int max = 1;
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) {
                max = d;
                if (n / d <= 10_000_000) {
                    return n / d;
                }
            }
        }
        return max;
    }
}