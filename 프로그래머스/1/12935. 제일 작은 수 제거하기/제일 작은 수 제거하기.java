import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        List<Integer> list = new ArrayList<>();
        int idx = -1;
        int min = Integer.MAX_VALUE;
        
        for(int i=0 ;i<arr.length; i++) {
            if(min > arr[i]) {
                idx = i;
                min = arr[i];
            }
        }
        for(int i=0; i<arr.length; i++) {
            if(i == idx) continue;
            list.add(arr[i]);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}