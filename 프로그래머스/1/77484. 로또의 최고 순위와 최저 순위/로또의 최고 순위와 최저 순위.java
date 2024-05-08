import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 2개맞으면 5등 그 이후로 하나씩 등수 업
        // 알아볼 수 없는 숫자는 0
        // 간단하게는 그냥 주어진 숫자로만 맞은 수 가 최소
        // 0을 모두 맞는 수로 바꾸면 최대 인데
        // 예외가 생길거같은건 
        // 1 ~ 45 사이의 숫자라는걸 생각해야함 근데 상관없지않나? 어차피 6개 제외하고 하나 고르면 되는거
        // 최대 맞은수와 최소 맞은 수 계싼가능
        
        int zeroCnt = 0;
        int matchCnt = 0;
        
        for(int i=0; i<lottos.length; i++) {
            int a = lottos[i];
            if(a == 0) {
                zeroCnt++;
                continue;
            }
            for(int j=0; j<win_nums.length; j++) {
                if(a == win_nums[j]) {
                    matchCnt++;
                    break;
                }
            }
        }
        int minMatch = matchCnt;
        int maxMatch = matchCnt + zeroCnt;
        return new int[]{getResult(maxMatch), getResult(minMatch)};
    }
    
    private int getResult(int cnt) {
        if(cnt == 6) return 1;
        else if(cnt == 5) return 2;
        else if(cnt == 4) return 3;
        else if(cnt == 3) return 4;
        else if(cnt == 2) return 5;
        else return 6;
    }
}