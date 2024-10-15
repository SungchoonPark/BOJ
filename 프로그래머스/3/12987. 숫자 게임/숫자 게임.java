import java.util.*;

class Solution {
    
    public int solution(int[] A, int[] B) {
        int result = 0;
        int[] check = new int[B.length]; // B 배열의 원소 사용 여부를 체크하는 배열
        
        Arrays.sort(B); // B 배열을 정렬하여 이분탐색 준비
        
        for (int a : A) {
            int start = 0;
            int end = B.length - 1;
            int tmpIdx = -1;
            
            // 이분탐색을 통해 최소로 큰 원소 값 구하기
            while (start <= end) {
                int middle = (start + end) / 2;
                
                if (B[middle] > a) {
                    // A의 원소보다 큰 경우
                    tmpIdx = middle;
                    end = middle - 1; // 더 작은 범위에서 찾기
                } else {
                    // A의 원소보다 작은 경우
                    start = middle + 1; // 더 큰 범위에서 찾기
                }
            }
            
            // tmpIdx가 -1이면 A의 원소보다 큰 B의 원소가 없음 -> 다음 A의 원소로 넘어감
            if (tmpIdx == -1) continue;
            
            // 찾은 B[tmpIdx]가 사용된 원소라면, 사용되지 않은 다음 원소를 찾음
            while (tmpIdx < B.length && check[tmpIdx] > 0) {
                tmpIdx++;
            }
            
            // 사용되지 않은 원소를 찾으면 result를 증가시키고 그 원소를 사용 표시
            if (tmpIdx < B.length && check[tmpIdx] == 0) {
                check[tmpIdx] = 1;
                result++;
            }
        }
        
        return result;
    }
}
