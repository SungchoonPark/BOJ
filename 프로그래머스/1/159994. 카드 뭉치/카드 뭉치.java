import java.util.*;
class Solution {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        List<Integer> cards1Idx = new ArrayList<>();
        List<Integer> cards2Idx = new ArrayList<>();

        for (String word : goal) {
            boolean flag = false;
            for (int i = 0; i < cards1.length; i++) {
                if (cards1[i].equals(word)) {
                    flag = true;
                    cards1Idx.add(i);
                }
            }
            if (flag) continue;
            for (int i = 0; i < cards2.length; i++) {
                if (cards2[i].equals(word)) {
                    cards2Idx.add(i);
                }
            }
        }

        for (int i = 1; i < cards1Idx.size(); i++) {
            Integer tmp1 = cards1Idx.get(i);
            Integer tmp2 = cards1Idx.get(i - 1);
            if (tmp1 < tmp2 || tmp1 - tmp2 != 1) return "No";
        }
        for (int i = 1; i < cards2Idx.size(); i++) {
            Integer tmp1 = cards2Idx.get(i);
            Integer tmp2 = cards2Idx.get(i - 1);
            if (tmp1 < tmp2 || tmp1 - tmp2 != 1) return "No";
        }

        return "Yes";

    }
}