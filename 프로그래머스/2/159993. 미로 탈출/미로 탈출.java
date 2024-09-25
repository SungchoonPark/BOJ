import java.util.*;
class Solution {
    static char[][] arr;
    static boolean[][] isVisited;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        int answer = 0;
        int h = maps.length;
        int w = maps[0].length();
        
        int sx = 0;
        int sy = 0;
        
        int lx = 0;
        int ly = 0;
        
        int ex = 0;
        int ey = 0;
        arr = new char[h][w];
        
        for(int i=0; i<h; i++) {
            char[] crr = maps[i].toCharArray();
            for(int j=0; j<crr.length; j++) {
                char c = crr[j];
                if(c == 'S') {
                    sx = j;
                    sy = i;
                } else if (c == 'L') {
                    lx= j;
                    ly = i;
                } else if (c == 'E') {
                    ex = j;
                    ey = i;
                }
                arr[i][j] = c;
            }
                
        }
        
        isVisited = new boolean[h][w];
        int r1 = bfs(h, w, sx, sy, lx, ly);
        if(r1 == -1) return -1;
        answer += r1;
        
        isVisited = new boolean[h][w];
        int r2 = bfs(h, w, lx, ly, ex, ey);
        if(r2 == -1) return -1;
        answer += r2;
        
        return answer;
    }
    
    private static int bfs(int h, int w, int sx, int sy, int gx, int gy) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(sx, sy, 0));
        isVisited[sy][sx] = true;
        
        while(!q.isEmpty()) {
            Pos curPos = q.poll();
            
            System.out.println("위치 : (" + curPos.x + ", " + curPos.y + ")"  + "cnt  : " + curPos.cnt);
            if(curPos.x == gx && curPos.y == gy) {
                return curPos.cnt;
            }
            
            for(int i=0; i<4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];
                if(nx >= 0 && nx < w && ny >= 0 && ny < h) {
                    if(!isVisited[ny][nx] && arr[ny][nx] != 'X') {
                        isVisited[ny][nx] = true;
                        q.offer(new Pos(nx, ny, curPos.cnt + 1));
                    }
                }
            }
        }
        
        return -1;
    }
    
    static class Pos {
        int x;
        int y;
        int cnt;
        
        public Pos (int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}