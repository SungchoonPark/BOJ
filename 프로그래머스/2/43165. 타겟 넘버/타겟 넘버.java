import java.util.*;

class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, target, numbers, 0);
        return cnt;
    }
    
    private void dfs(int num, int target, int[] numbers, int idx) {
        if(idx == numbers.length) {
            if(num == target) cnt++;
            return;
        }
        
        dfs(num + numbers[idx], target, numbers, idx+1);
        dfs(num - numbers[idx], target, numbers, idx+1);
    }
}