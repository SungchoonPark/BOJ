import java.util.*;
class Solution {
    public int solution(int n) {
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) arr[i] = i;
        int cnt = 0;
        int start = 1;
        int end = 1;
        int sum = arr[1];
        while (start != n || end != n) {
            if (sum >= n) {
                if (sum == n) cnt++;
                if (start < n) sum -= arr[start++];
            }
            if (sum < n) {
                end++;
                sum += arr[end];
            }
        }
        return cnt+1;
    }
}