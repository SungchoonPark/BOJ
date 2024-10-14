import java.util.*;
class Solution {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
    public int solution(int[] queue1, int[] queue2) {
        
        // int totalCnt = queue1.length + queue2.length + 1;
        int totalCnt = 600_001;
        long total = 0;
        long q1Total = 0;
        long q2Total = 0;
        for(int i=0; i<queue1.length; i++) {
            total += queue1[i] + queue2[i];
            q1Total += queue1[i];
            q2Total += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        long goal = total / 2;
        int result = 0;
        
        while(true) {
            if(q1Total > q2Total) {
                int tmp = q1.poll();
                q1Total -= tmp;
                q2Total += tmp;
                q2.offer(tmp);
                result++;
            } else if(q1Total < q2Total) {
                int tmp = q2.poll();
                q2Total -= tmp;
                q1Total += tmp;
                q1.offer(tmp);
                result++;
            } else {
                break;
            }
            if(result >= totalCnt) return -1;
        }
        
        return result;
    }
}