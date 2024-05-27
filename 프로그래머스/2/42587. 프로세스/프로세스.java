import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Value> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++) {
            q.offer(new Value(priorities[i], i));
            pq.offer(priorities[i]);
        }
        
        int answer = 0;
        while(!q.isEmpty()) {
            int max = pq.peek();
            Value curV = q.poll();
            
            if(curV.p == max) {
                answer++;
                pq.poll();
                if(curV.l == location) {
                    break;
                }
            }
            
            q.offer(curV);
        }
        
        return answer;
    }
}

class Value {
    int p;
    int l;
    
    public Value(int p, int l) {
        this.p = p;
        this.l = l;
    }
}