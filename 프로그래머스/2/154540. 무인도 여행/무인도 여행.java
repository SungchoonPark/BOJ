import java.util.*;
class Solution {
    static char[][] arr;
    static List<Integer> result;
    static boolean[][] isVisited;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        // 숫자는 식량임
        arr = new char[maps.length][maps[0].length()];
        
        for(int i=0; i < maps.length; i++) {
            arr[i] = maps[i].toCharArray();
        }
        result = new ArrayList<>();
        isVisited = new boolean[101][101];
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(!isVisited[i][j] && arr[i][j] != 'X') {
                    isVisited[i][j] = true;
                    result.add(dfs(maps.length, maps[0].length(), j, i, (int) arr[i][j] - '0'));
                }
            }
        }
        
        result.sort(Comparator.naturalOrder());
        if(result.size() == 0) return new int[] {-1};
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static int dfs(int h, int w, int x, int y, int food) {
        int foods = food;
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(x, y));
        
        while(!stack.isEmpty()) {
            Pos curPos = stack.pop();
            
            for(int i=0; i<4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];
                
                if(nx >= 0 && nx < w && ny >= 0 && ny < h) {
                    if(!isVisited[ny][nx] && arr[ny][nx] != 'X') {
                        isVisited[ny][nx] = true;
                        stack.push(new Pos(nx, ny));
                        foods += (int) arr[ny][nx] - '0';
                    }
                }
            }
        }
        
        return foods;
    }
    
    static class Pos {
        int x;
        int y;
        
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}