import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        // 예산(budget)에 맞게 d에서 부서를 제일 많이 뽑기
        // 일단 정렬해서 하면 될듯?
        Arrays.sort(d);
        int answer = 0;
        int tmp = 0;
        for(int i : d) {
            tmp += i;
            answer++;
            if(tmp > budget) {
                tmp -=i;
                answer--;
                break;
            }
        }
        return answer;
    }
}