import java.util.*;
class Solution {
    public int solution(int[] array, int height) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result= 0;
        
        for(int i : array) {
            pq.offer(i);
        }
        pq.offer(height);
        int i = 0;
        while(!pq.isEmpty()) {
            if(pq.poll() == height) {
                result = i;
                break;
            }
            
            i++;
        }
        return result;
    }
}

