import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.offer(i);
        }
        
        while(!pq.isEmpty()) {
            if(pq.size() == 1 && pq.peek() < K) {
                return -1;
            }
            if(pq.peek() >= K) break;
            
            int tmp1 = pq.poll();
            int tmp2 = pq.poll();
            pq.offer(tmp1 + (tmp2 * 2));
            answer++;
        }
        
        
        return answer;
    }
}