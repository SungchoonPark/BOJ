import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        List<Integer> list = new ArrayList<>();
        
        pq.offer(score[0]);
        list.add(score[0]);
        
        for(int i=1; i<score.length; i++) {
            int tmp = score[i];
            
            if(pq.size() < k) {
                pq.offer(tmp);
                list.add(pq.peek());
                continue;
            }
            
            // 3인 경우 + 최소값보다 크면 넣으면됨
            if(tmp > pq.peek()) {
                pq.poll();
                pq.offer(tmp);
                list.add(pq.peek());
            } else {
                list.add(pq.peek());
            }
        }
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}