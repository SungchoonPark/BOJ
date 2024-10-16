import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] result = new int[n];
        
        int q = s / n;
        int r = s % n;
        if(q == 0) return new int[]{-1};
        for(int i=0; i<n - r; i++) {
            result[i] = q;
        }
        for(int i=n -r; i<n; i++) {
            result[i] = q + 1;
        }
        
        return result;
    }
}