import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p2 - p1);
        Queue<Process> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
            pq.offer(priorities[i]);
        }
        
        int answer = 1;
        while(!q.isEmpty()) {
            Integer maxPrior = pq.peek();
            Process curP = q.poll();
            
            if(maxPrior == curP.tmp) {
                // 우선순위가 높은거 맞음
                pq.poll();
                if(curP.idx == location) return answer;
                else {
                    answer++;
                }
            } else {
                // 우선순위 안맞으니 다시 큐에 삽입
                q.offer(curP);
            }
        }
        
        return -1;
    }
}

class Process{
    int idx;
    int tmp;
    
    public Process(int idx, int tmp) {
        this.idx = idx;
        this.tmp = tmp;
    }
}