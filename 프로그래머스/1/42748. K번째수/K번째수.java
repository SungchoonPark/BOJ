import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> results = new ArrayList<>();
        
        for(int i=0; i<commands.length; i++) {
            int st = commands[i][0] - 1;
            int ed = commands[i][1] - 1;
            int seq = commands[i][2] - 1;
            
            int[] newarr = new int[ed - st + 1];
            
            int a = 0;
            for(int j=st; j<=ed; j++) {
                newarr[a++] = array[j];
            }
            
            Arrays.sort(newarr);
            results.add(newarr[seq]);
        }
        
        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}