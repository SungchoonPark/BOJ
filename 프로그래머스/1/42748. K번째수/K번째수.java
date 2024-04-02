import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int findIdx = commands[i][2];
            
            int[] newArr = Arrays.copyOfRange(array, start-1, end);
            
            Arrays.sort(newArr);
            
            list.add(newArr[findIdx-1]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}