import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int idx = 0;
        int cnt = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        while(true) {
            int size = q.size();
            
            if(idx == numbers.length) {
                for(int i=0; i<size; i++) {
                    Integer pop = q.poll();
                    if(pop == target) cnt++;
                }
                break;
            } else {
                for(int i=0; i<size; i++) {
                    Integer pop = q.poll();
                    int a = pop + numbers[idx];
                    int b = pop - numbers[idx];
                    // System.out.println("a : " + a + " " + "b : " + b);
                    q.offer(a);
                    q.offer(b);
                }
                // System.out.println();
                idx++;
            }
        }
        
        return cnt;
    }
}