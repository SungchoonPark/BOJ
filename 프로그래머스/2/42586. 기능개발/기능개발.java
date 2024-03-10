import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int tmp = 100 - progresses[i];
            if (tmp % speeds[i] == 0) {
                queue.add(tmp / speeds[i]);
            } else {
                queue.add(tmp / speeds[i] + 1);
            }
        }
        while (!queue.isEmpty()) {
            int cnt = 1;
            Integer poll = queue.poll();

            while(!queue.isEmpty() && queue.peek() <= poll) {
                cnt++;
                queue.poll();
            }

            list.add(cnt);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}