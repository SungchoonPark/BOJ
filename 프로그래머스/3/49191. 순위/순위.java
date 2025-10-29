class Solution {
    public int solution(int n, int[][] results) {
        
        boolean[][] win = new boolean[n][n];
        for (int[] r : results) {
            win[r[0]-1][r[1]-1] = true;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int know = 0;
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                if(win[i][j] || win[j][i]) know++;
            }
            
            if(know == n - 1) answer++;
        }
        
        return answer;
    }
}