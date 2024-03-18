import java.util.*;
class Solution {
    public static int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>(List.of(gems));

        int start = 0;
        int end = gems.length - 1;

        int s = 0;
        int e = 0;

        Map<String, Integer> gemMap = new HashMap<>();
        gemMap.put(gems[s], 1);

        while (s < gems.length) {

            if (gemMap.keySet().size() == gemSet.size()) {
                if (e - s < end - start) {
                    start = s;
                    end = e;
                }

                gemMap.put(gems[s], gemMap.get(gems[s]) - 1);
                if (gemMap.get(gems[s]) == 0) gemMap.remove(gems[s]);

                s++;
            } else if (e < gems.length - 1) {
                e++;
                gemMap.put(gems[e], gemMap.getOrDefault(gems[e], 0) + 1);
            } else {
                break;
            }
        }

        return new int[]{start + 1, end + 1};
    }
}