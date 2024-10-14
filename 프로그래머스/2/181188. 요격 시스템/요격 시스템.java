import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // 구간을 끝점 기준으로 정렬
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int result = 0;  // 요격 미사일의 최소 개수
        double lastIntercept = -Double.MAX_VALUE;  // 마지막으로 발사한 요격 미사일의 위치
        
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];
            
            // 현재 구간의 시작점이 마지막 요격 위치보다 크면 새로운 미사일 필요
            if (lastIntercept < start) {
                result++;
                lastIntercept = end - 0.1;  // 구간의 끝에 가까운 위치에서 요격
            }
        }
        
        return result;
    }
}
