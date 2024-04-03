import java.util.*;
class Solution {
    static int[] distX = {1, -1, 0, 0};
    static int[] distY = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        int answer = 0;
        System.out.println("n : " + (maps[0].length-1) + " m : " + (maps.length-1));
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        Queue<Dot> q = new LinkedList<>();
        q.offer(new Dot(0, 0, 1));
        isVisited[0][0] = true;
        
        boolean flag = false;
        while(!q.isEmpty()) {
            Dot curDot = q.poll();
            if(curDot.x == maps[0].length-1 && curDot.y == maps.length-1) {
                flag = true;
                answer = curDot.cost;
                break;
            }
            for(int i=0; i<4; i++) {
                int newX = curDot.x + distX[i];
                int newY = curDot.y + distY[i];
                
                if(newX >= 0 && newX < maps[0].length && newY >= 0 && newY < maps.length) {
                    if(!isVisited[newY][newX] && maps[newY][newX] == 1) {
                        isVisited[newY][newX] = true;
                        q.offer(new Dot(newX, newY, curDot.cost + 1));
                    }
                }
            }
        }
        if(!flag) return -1;
        return answer;
    }
}

class Dot {
    int x;
    int y;
    int cost;
    
    public Dot(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}