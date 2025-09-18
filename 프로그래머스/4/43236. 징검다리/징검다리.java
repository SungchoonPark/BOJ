import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int start = 1;
        int end = distance;
        
        Arrays.sort(rocks);
        int answer = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(canSolve(mid, rocks, n, distance)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean canSolve(int minDistance, int[] rocks, int n, int end) {
        int count = 0;
        
        int prev = 0;
        for(int i=0; i<rocks.length; i++) {
            int dist = rocks[i] - prev;
            
            if(dist < minDistance) {
                count++;
            } else {
                prev = rocks[i];   
            }
        }
        
        if(end - prev < minDistance) count++;
        
        return count <= n;
    }
}