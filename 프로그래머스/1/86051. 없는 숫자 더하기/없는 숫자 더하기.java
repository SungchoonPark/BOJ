import java.util.*;
class Solution {
    private static Set<Integer> set = new HashSet<>();
    public int solution(int[] numbers) {
        int answer = 0;
        for(int i=0; i<=9; i++) {
            set.add(i);
        }
        for(int n : numbers) {
            if(set.contains(n)) {
                set.remove(n);
            }
        }
        for(int n : set) {
            answer += n;
        }
        
        return answer;
    }
}