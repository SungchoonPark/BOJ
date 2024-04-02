import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] newArr = new Integer[numlist.length];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numlist.length; i++) {
            newArr[i] = numlist[i];
        }
        Arrays.sort(newArr, (o1, o2) -> {
            int diff1 = Math.abs(o1 - n);
            int diff2 = Math.abs(o2 - n);
            
            if(diff1 == diff2) return o2 - o1;
            return diff1 - diff2;
        });
        for(Integer a : newArr) {
            list.add(a);
        }
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}