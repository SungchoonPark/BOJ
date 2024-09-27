import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        ArrayList<Integer> numbers = new ArrayList<>();
        long[] factorial = new long[n + 1];
        int[] answer = new int[n];
        StringBuilder sb = new StringBuilder();
        
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            numbers.add(i);
        }
        
        k--; // 0-indexed adjustment
        
        for (int i = 0; i < n; i++) {
            int idx = (int) (k / factorial[n - 1 - i]);
            answer[i] = numbers.remove(idx);
            k %= factorial[n - 1 - i];
        }
        
        return answer;
    }
}
