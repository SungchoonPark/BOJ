import java.util.*;
class Solution {
    static int answer = 0;
    static boolean[] isVisited;
    public int solution(int x, int y, int n) {
        isVisited = new boolean[1_000_010];
        if(x == y) return 0;
        bfs(x, y, n);
        
        if(answer == 0) return -1;
        return answer;
    }
    
    private static void bfs(int start, int goal, int n) {
        Queue<Num> q = new LinkedList<>();
        q.add(new Num(start, 0));
        
        while(!q.isEmpty()) {
            Num curNum = q.poll();
            
            if(curNum.value == goal) {
                answer = curNum.cnt;
                return;
            }
            
            if(curNum.value + n < 1_000_010 && !isVisited[curNum.value + n]) {
                isVisited[curNum.value + n] = true;
                q.offer(new Num(curNum.value + n, curNum.cnt+1));
            }
            if(curNum.value * 2 < 1_000_010 &&!isVisited[curNum.value * 2]) {
                isVisited[curNum.value * 2] = true;
                q.offer(new Num(curNum.value * 2, curNum.cnt+1));
            } 
            if(curNum.value * 3 < 1_000_010 &&!isVisited[curNum.value * 3]) {
                isVisited[curNum.value * 3] = true;
                q.offer(new Num(curNum.value * 3, curNum.cnt+1));
            } 
        }
    }
    
    static class Num {
        int value;
        int cnt;
        
        public Num(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }
}