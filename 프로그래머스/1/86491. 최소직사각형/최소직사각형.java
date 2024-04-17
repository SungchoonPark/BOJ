import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        // 가로 제일 긴 애를 선택하고 걔 명함은 빼고 이제
        // 나머지 명함들을 다 뒤집어보고 가로와 세로가 모두 현 명함의 세로보다 큰 애를 선택하고
        // 그 애의 가장 작은 값을 세로로 두기
        // 근데 그런 명함이 여러개라면
        int width = 0;
        int height = 0;
        int idx = -1;
        for(int i=0; i<sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            
            if(w > width) {
                width = w;
                idx = i;
                height = Math.min(sizes[i][0], sizes[i][1]);
            }
        }
        
        for(int i=0; i<sizes.length; i++) {
            if(i == idx) continue;
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if(w > height && h > height) {
                height = Math.min(w, h);
            }
        }
        return width * height;
    }
}