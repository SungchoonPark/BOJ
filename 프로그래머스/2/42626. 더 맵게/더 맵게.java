import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        int count = 0;
        for(int s : scoville) {
            pq.offer((long)s);
        }
        
        boolean isPossible = true;
        while(true) {
            if(pq.peek() >= K) break;
            
            if(pq.size() == 1) {
                isPossible = false;
                break;
            }
            
            count++;
            long minS = pq.poll();
            long secondMinS = pq.poll();
            pq.offer(minS + (secondMinS * 2));
        }
        
        if(isPossible && count == 0) return 0;
        if(count == 0 || !isPossible) return -1;
        return count;
    }
}