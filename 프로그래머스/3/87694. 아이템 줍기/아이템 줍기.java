import java.util.*;

class Solution {
    static List<Rectangle> rectangles = new ArrayList<>();
    static int[][] map;
    static int answer;
    static int[] distX = {1, -1, 0, 0};
    static int[] distY = {0, 0, 1, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        
        for(int i=0; i<rectangle.length; i++) {
            int leftX = rectangle[i][0] * 2;
            int leftY = rectangle[i][1] * 2;
            int rightX = rectangle[i][2] * 2;
            int rightY = rectangle[i][3] * 2;
            
            for(int j=leftY; j<=rightY; j++) {
                for(int k=leftX; k<=rightX; k++) {
                    map[j][k] = -1;
                }
            }
            
            rectangles.add(new Rectangle(leftX, leftY, rightX, rightY));
        }
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer;
    }
    
    private void bfs(int charX, int charY, int goalX, int goalY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{charX, charY, 1});
        map[charY][charX] = 1;
        while(!q.isEmpty()) {
            int[] curChar = q.poll();
            
            int curX = curChar[0];
            int curY = curChar[1];
            int curCnt = curChar[2];
            // System.out.println("[NOT]curCnt : " + curCnt);
            // System.out.println("curX : " + curX);
            // System.out.println("curY : " + curY);
            // System.out.println("goalX : " + goalX);
            // System.out.println("goalY : " + goalY);
            // System.out.println();
            
            if(curX == goalX && curY == goalY) {
                System.out.println("[YES]curCnt : " + curCnt);
                answer = curCnt / 2;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int newX = curX + distX[i];
                int newY = curY + distY[i];
                
                if(map[newY][newX] == -1 && isBoundary(newX, newY)) {
                    map[newY][newX] = curCnt + 1;
                    q.offer(new int[]{newX, newY, curCnt+1});
                }
            }
        }
    }
    
    private boolean isBoundary(int x, int y) {
        for(Rectangle rec : rectangles) {
            if(x > rec.leftX && y > rec.leftY && x < rec.rightX && y < rec.rightY) return false;
        }
        return true;
    }
}

class Rectangle {
    int leftX;
    int leftY;
    int rightX;
    int rightY;
    
    Rectangle(int leftX, int leftY, int rightX, int rightY) {
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;
        this.rightY = rightY;
    }
}