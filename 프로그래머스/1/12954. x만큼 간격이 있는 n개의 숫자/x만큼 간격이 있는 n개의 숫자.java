import java.util.*;
class Solution {
    public long[] solution(long x, int n) {
        long[] answer = {};
        List<Long> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add((long)(x * i));
        }
        return list.stream().mapToLong(Long::longValue).toArray();
    }
}