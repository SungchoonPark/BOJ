class Solution {
    public int solution(int n, int[][] computers) {
        
        int count = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<computers.length; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            search(i, computers, visited);
            count++;
        }
        
        return count;
    }
    
    private void search(int searchNum, int[][] computers, boolean[] visited) {
        for(int i=0; i<computers[searchNum].length; i++) {
            if(!visited[i] && i!=searchNum && computers[searchNum][i] == 1) {
                visited[i] = true;
                search(i, computers, visited);
            }
        }
    }
}