import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        
        for(int i : works) {
            pq.offer(i);
        }
        
        while(n > 0) {
            // System.out.println(pq.poll());
            
            pq.offer(pq.poll() - 1);
            n--;
        }
        
        long result = 0L;
        while(!pq.isEmpty()) {
            int tmp = pq.poll();
            tmp = Math.max(0, tmp);
            result += (int) Math.pow(tmp, 2);
        }
        
        return result;
    }
}