import java.util.*;

class Solution {
    public static int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;

        int sum = sequence[0];

        int start = 0;
        int end = start;
        while(start < len && end < len) {
            if(sum == k) {
                if(Math.abs(end - start) < minLen) {
                    minLen = Math.abs(end - start);
                    minStart = start;
                    minEnd = end;
                }
                sum -= sequence[start++];
            } else if (sum >= k) {
                sum -= sequence[start++];
            } else if (sum < k) {
                if(end != len - 1) sum += sequence[++end];
                else end++;
            }
        }

        return new int[]{minStart, minEnd};
    }
}