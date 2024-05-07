import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        // 흠. 아마 가장 깊은 높이를 고르고 그다음에 가장 오른쪽 좌표를 구하면 될듯.
        // 즉, 가장 아래와 가장 오른쪽을 고르면 됨.
        // 가장 위쪽과 가장 왼쪽
        int luy = Integer.MAX_VALUE;
        int lux = Integer.MAX_VALUE;
        int rdy = Integer.MIN_VALUE;
        int rdx = Integer.MIN_VALUE;
        
        for(int i=0; i<wallpaper.length; i++) {
            String tmp = wallpaper[i];
            for(int j=0; j<tmp.length(); j++) {
                char c = tmp.charAt(j);
                if(c == '#') {
                    // i는 y j는 x
                    int h = i + 1;
                    int w = j + 1;
                    if(i < luy) luy = i;
                    if(j < lux) lux = j;
                    if(h > rdy) rdy = h;
                    if(w > rdx) rdx = w;
                }
            }
        }
        
        return new int[]{luy, lux, rdy, rdx};
    }
}