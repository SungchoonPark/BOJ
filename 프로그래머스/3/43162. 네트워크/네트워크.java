class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                dfs(i, computers);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private void dfs(int num, int[][] computers) {
        for(int i=0; i<computers.length; i++) {
            if(computers[num][i] == 1 && !visit[i]) {
                visit[i] = true;
                dfs(i, computers);
            }
        }
    }
}