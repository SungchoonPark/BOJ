import java.util.*;

class Solution {
    int[] oils;
    boolean[][] visited;
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] land) {
        oils = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];
        
        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[i].length; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(new Pos(j, i), land);
                }
            }
        }
        
        int max = 0;
        for(int i=0; i<oils.length; i++) {
            max = Math.max(max, oils[i]);
        }
        
        return max;
    }
    
    private void dfs(Pos start, int[][] land) {
        Deque<Pos> stack = new LinkedList<>();
        stack.push(start);
        Set<Integer> visitColumns = new HashSet<>();
        
        int area = 0;
        while(!stack.isEmpty()) {
            Pos curPos = stack.pop();
            int cx = curPos.x;
            int cy = curPos.y;
            
            visitColumns.add(cx);
            area++;
            
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < visited[0].length && ny >= 0 && ny < visited.length) { 
                    if(!visited[ny][nx] && land[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        stack.push(new Pos(nx, ny));
                    }
                }
            }
        }
        
        for(int vc : visitColumns) {
            oils[vc] += area;
        }
    }
}

class Pos {
    int x;
    int y;
    
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}