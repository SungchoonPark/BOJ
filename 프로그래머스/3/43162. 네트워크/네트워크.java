import java.util.*;

class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        visit = new boolean[computers.length];
        int cnt = 0;
        for(int i=0; i<computers.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i, computers);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private void dfs(int x, int[][] computers) {
        for(int i=0; i<computers.length; i++) {
            if(computers[x][i] == 1 && !visit[i]) {
                visit[i] = true;
                dfs(i, computers);
            }
        }
    }
}