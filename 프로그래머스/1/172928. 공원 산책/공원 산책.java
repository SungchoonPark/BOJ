import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int sx = -1;
        int sy = -1;
        int len = park[0].length();
        String[][] arr = new String[park.length][park[0].length()];
        
        for(int i=0; i<park.length; i++) {
            String[] tmp = park[i].split("");
            for(int j=0; j<len; j++) {
                String test = tmp[j];
                arr[i][j] = test;
                if(test.equals("S")) {
                    sy = i;
                    sx = j;
                }
            }
        }
        
//         for(int i=0; i<arr.length; i++) {
//             for(int j=0; j<arr[0].length; j++) {
//                 System.out.print(arr[i][j]);
//             }
//                 System.out.println();
            
//         }
        
        for(String route : routes) {
            String[] tmp = route.split(" ");
            int[] dire = getDire(tmp[0], Integer.parseInt(tmp[1]));
            
            int nY = sy + dire[0];
            int nX = sx + dire[1];
            
            
            if(nX < 0 || nY < 0 || nX >= len || nY >= len) continue;
            boolean flag = false;
            int startY = Math.min(nY, sy);
            int startX = Math.min(nX, sx);
            int endY = Math.max(nY, sy);
            int endX = Math.max(nX, sx);
            for(int i=startY; i <= endY; i++) {
                for(int j=startX; j<=endX; j++) {
                    if(arr[i][j].equals("X")) {
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            if(flag) continue;
            sy = nY;
            sx = nX;
        }
        return new int[]{sy, sx};
    }
    
    private int[] getDire(String dire, int cnt) {
        if(dire.equals("E")) {
            return new int[]{0, cnt};
        } else if(dire.equals("S")) {
            return new int[]{cnt, 0};
        } else if(dire.equals("W")) {
            return new int[]{0, -cnt};
        } else {
            return new int[]{-cnt, 0};
        }
    }
}