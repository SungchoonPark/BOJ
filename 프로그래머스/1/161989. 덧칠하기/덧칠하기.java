import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] arr = new boolean[n+1];
        for(int a : section) {
            arr[a] = true;
        }
        
        for(int i=1; i<=n; i++) {
            if(arr[i] == true) {
                for(int j=0; j<m; j++) {
                    if(i + j <= n) {
                        arr[i + j] = false;
                    }
                }
                answer++;
            }
        }
        
        return answer;
    }
}