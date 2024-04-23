import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        // 이 문제는 최대한 높은 점수의 사과들이 상자에 들어가면 되는거임.
        // 그리고 그 상자에 들어간 제일 낮은 점수와 m을 곱해서 출력하면 됨.
        Arrays.sort(score);
        int[] tmp = new int[score.length]; // 0 ~ 6 (7)
        // for(int i=0; i<score.length; i++) System.out.print(score[i] + " ");
        // System.out.println();
        for(int i=0; i<score.length; i++) {
            tmp[i] = score[score.length - 1 - i];
            // 0 ~ 6 <-> 6 ~ 0
        }
        // for(int i=0; i<score.length; i++) System.out.print(tmp[i] + " ");
        int[][] arr = new int[score.length / m][m];
        int idx = 0;
        int answer = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = tmp[idx++];
            }
        }
        
        // for(int i=0; i<arr.length; i++) {
        //     for(int j=0; j<m; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        for(int i=0; i<arr.length; i++) {
            answer += arr[i][m-1] * m;
        }
        
        return answer;
    }
}