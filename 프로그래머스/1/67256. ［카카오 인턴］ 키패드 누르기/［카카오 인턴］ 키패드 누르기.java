import java.util.*;

class Position {
    int x;
    int y;
    public Position(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 아 어차피 상하좌우는 모두 길이가 1이니까 층별로 나눠도 의미없음
        Position curR = new Position(3, 0);
        Position curL = new Position(3, 2);
        for(int j=0; j<numbers.length; j++) {
            int i = numbers[j];
            if(i == 1 || i == 4 || i == 7) {
                sb.append("L");
                if(i==1) {
                    curL.y = 0;
                    curL.x = 0;
                }
                else if(i==4) {
                    curL.y = 1;
                    curL.x = 0;
                }
                else {
                    curL.y = 2;
                    curL.x = 0;
                }
            } else if (i == 3 || i == 6 || i == 9) {
                sb.append("R");
                if(i==3) {
                    curR.y = 0;
                    curR.x = 2;
                }
                else if(i==6) {
                    curR.y = 1;
                    curR.x = 2;
                }
                else {
                    curR.y = 2;
                    curR.x = 2;
                }
            } else {
                Position cur;
                if(i==2) cur = new Position(0, 1);
                else if(i==5) cur = new Position(1, 1);
                else if(i==8) cur = new Position(2, 1);
                else cur = new Position(3, 1);
                
                int tmp1 = Math.abs(curL.y - cur.y) + Math.abs(curL.x - cur.x);
                int tmp2 = Math.abs(curR.y - cur.y) + Math.abs(curR.x - cur.x);
                if(tmp1 > tmp2) {
                    sb.append("R");
                    curR.y = cur.y;
                    curR.x = cur.x;
                }
                else if(tmp1 < tmp2) {
                    sb.append("L");
                    curL.y = cur.y;
                    curL.x = cur.x;
                }
                else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        curL.y = cur.y;
                        curL.x = cur.x;
                    } else {
                        sb.append("R");
                        curR.y = cur.y;
                        curR.x = cur.x;
                    }
                }
            }
        }
        
        return sb.toString();
    }
}