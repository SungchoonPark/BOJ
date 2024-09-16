import java.util.*;

class Solution {
    static List<Pos>[][] arr;
    public int solution(String dirs) {
        int answer = 0;
        int real = 0;
        arr = new List[11][11];
        
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        
        String[] ope = dirs.split("");
        int curY = 5;
        int curX = 5;
        
        for(String o : ope) {
            if(o.equals("U")) {
                if(curY - 1 >= 0 && curY - 1 < 11) {
                    if(isPossible(curX, curY - 1, curX, curY)) {
                        answer++;
                        real++;
                    }
                    curY--;
                }
            } else if(o.equals("D")) {
                if(curY + 1 >= 0 && curY + 1 < 11) {
                    if(isPossible(curX, curY + 1, curX, curY)) {
                        answer++;
                        real++;
                        
                    }
                    curY++;
                }
            } else if(o.equals("R")) {
                if(curX + 1 >= 0 && curX + 1 < 11) {
                    if(isPossible(curX + 1, curY, curX, curY)) {
                        answer++;
                        real++;
                        
                    }
                    curX++;
                }
            } else {
                if(curX - 1 >= 0 && curX - 1 < 11) {
                    if(isPossible(curX - 1, curY, curX, curY)) {
                        answer++;
                        real++;
                        
                    }
                    curX--;
                }   
            }
        }
        
        // System.out.println("전체 명령어 개수 : " + dirs.length());
        // System.out.println("실제 명령어 개수 : " + real);
        
        return answer;
    }
    
    private static boolean isPossible(int goalX, int goalY, int curX, int curY) {
        boolean flag = true;
        List<Pos> tmp = arr[goalY][goalX];
        for(Pos p : tmp) {
            if(p.x == curX && p.y == curY) {
                flag = false;
                break;
            }
        }
        if(flag) {
            arr[curY][curX].add(new Pos(goalX, goalY));
            tmp.add(new Pos(curX, curY));
        }
        return flag;
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