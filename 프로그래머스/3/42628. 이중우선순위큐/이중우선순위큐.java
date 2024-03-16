import java.util.*;
class Solution {
    static PriorityQueue<Integer> minPq = new PriorityQueue<>();
    static PriorityQueue<Integer> maxPq =
            new PriorityQueue<>((a, b) -> b - a);
    static StringTokenizer st;
    public static int[] solution(String[] operations) {
        for (String ops : operations) {
            st = new StringTokenizer(ops);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            operation(op, num);
        }

        if (minPq.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[] {maxPq.peek(), minPq.peek()};
        }
    }

    public static void operation(String op, int num) {
        switch (op) {
            case "I" -> {
                minPq.add(num);
                maxPq.add(num);
            }
            case "D" -> {
                switch (num) {
                    case 1 -> {
                        if (!maxPq.isEmpty()) {
                            Integer poll = maxPq.poll();
                            minPq.remove(poll);
                        }
                    }
                    case -1 -> {
                        if (!maxPq.isEmpty()) {
                            Integer poll = minPq.poll();
                            maxPq.remove(poll);
                        }
                    }
                }
            }
        }
    }
}