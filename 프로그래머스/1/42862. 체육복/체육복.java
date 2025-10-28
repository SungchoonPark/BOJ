import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 여벌 가져온놈이 도난당하면 1개로 침 -> 못빌려줌
        // 최대한 빌려줄 수 있는 학생수가 몇명이냐 ?
        
        Set<Integer> wear = new HashSet<>();
        boolean[] isNeedHelp = new boolean[n + 1];
        boolean[] isCanBorrow = new boolean[n + 1];
        
        for(int i=1; i<=n; i++) wear.add(i);
        for(int r : reserve) {
            isCanBorrow[r] = true;
        }
        
        for(int l : lost) {
            if(isCanBorrow[l]) isCanBorrow[l] = false;
            else {
                isNeedHelp[l] = true;
                wear.remove(l);
            }
        }
        
        for(int i=1; i<n + 1; i++) {
            if(!isCanBorrow[i]) continue;
            
            int front = i - 1;
            int back = i + 1;
            
            if(front > 0 && isNeedHelp[front]) {
                isNeedHelp[front] = false;
            } else if(back < n +1 && isNeedHelp[back]) {
                isNeedHelp[back] = false;
            }
        }
        
        int result = -1;
        for(boolean t : isNeedHelp) {
            if(!t) result++;
        }
        return result;
    }
}