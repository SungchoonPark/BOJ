import java.util.*;
class Solution {
    // 2 3 4 5
    // 3 2 2 3
    
    public int[] solution(int n, long left, long right) {
        int a = (int)(right - left);
        int[] answer = new int[a + 1];
        int tmp = 0;
        for(long i = left; i<=right; i++) {
            answer[tmp++] = Math.max((int)(i / n) + 1, (int)(i % n) + 1);
        }
        return answer;
        // return Arrays.stream(answer).mapToInt(l -> (int)l).toArray();
    }
}