import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 서로 다른 개수 세고 nums.length/2 와 서로 다른 개수 중 최소값 출력하면 될듯
        int diff = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        
        
        return Math.min(set.size(), nums.length/2);
    }
}