import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            String a1 = String.valueOf(i1);
            String a2 = String.valueOf(i2);
            
            String order1 = a1 + a2;
            String order2 = a2 + a1;
            
            return order2.compareTo(order1);
        });
        
        for(int i : numbers) pq.offer(i);
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}