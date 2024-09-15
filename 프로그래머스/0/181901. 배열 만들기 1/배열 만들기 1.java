import java.util.*;
class Solution {
    public int[] solution(int n, int k) {
        List<Integer> list = new ArrayList<>();
        
        int i =1;
        int tmp = k;
        while(tmp <= n) {
            list.add(k * i);
            i++;
            tmp = k * i;
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}