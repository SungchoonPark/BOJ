import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        Card[] cards = new Card[5];
        int[] numCounts = new int[10];
        Map<Character, Integer> colorCount = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            char color = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            numCounts[num]++;
            Integer orDefault = colorCount.getOrDefault(color, 0);
            colorCount.put(color, orDefault + 1);

            cards[i] = new Card(color, num);
        }

        int sum = 0;

        boolean isSameColor = isAllSameColor(cards);
        boolean isConsecutive = isConsecutive(cards);
        int scoreIfThreeSameAndTwoSame = getScoreIfThreeSameAndTwoSame(numCounts);
        int scoreIfThreeSame = getScoreIfThreeSame(numCounts);
        int twoSameAndTwoSame = isTwoSameAndTwoSame(numCounts);
        int twoSame = isTwoSame(numCounts);

        if (isSameColor && isConsecutive) {
            sum = Math.max(sum, getMaxNum(cards) + 900);
        } else if (isSameColor && !isConsecutive) {
            sum = Math.max(sum, getMaxNum(cards) + 600);
        } else if (!isSameColor && isConsecutive) {
            sum = Math.max(sum, getMaxNum(cards) + 500);
        } else if (getScoreIfFourSameNum(numCounts) != 0) {
            sum = Math.max(sum, getScoreIfFourSameNum(numCounts));
        } else if (scoreIfThreeSameAndTwoSame != 0) {
            sum = Math.max(sum, scoreIfThreeSameAndTwoSame);
        } else if (scoreIfThreeSame != 0) {
            sum = Math.max(sum, scoreIfThreeSame);
        } else if (twoSameAndTwoSame != 0) {
            sum = Math.max(sum, twoSameAndTwoSame);
        } else if (twoSame != 0) {
            sum = Math.max(sum, twoSame);
        } else {
            sum = Math.max(sum, getMaxNum(cards) + 100);
        }

        System.out.print(sum);


    }

    private static boolean isConsecutive(Card[] cards) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Card card : cards) {
            pq.offer(card.num);
        }

        int curNum = pq.poll();
        while (!pq.isEmpty()) {
            Integer num = pq.poll();
            if (num != curNum + 1) {
                return false;
            }
            curNum = num;
        }

        return true;
    }

    private static int getScoreIfFourSameNum(int[] cardNumCount) {
        for (int i = 1; i <= 9; i++) {
            if (cardNumCount[i] == 4) {
                return i + 800;
            }
        }

        return 0;
    }

    private static int getScoreIfThreeSameAndTwoSame(int[] cardNumCount) {
        int tmpSum = 0;
        boolean isThree = false;
        boolean isTwo = false;

        for (int i = 1; i <= 9; i++) {
            if (cardNumCount[i] == 3) {
                isThree = true;
                tmpSum += i * 10;
            } else if (cardNumCount[i] == 2) {
                isTwo = true;
                tmpSum += i;
            }
        }

        if (isThree && isTwo) {
            return tmpSum + 700;
        } else {
            return 0;
        }
    }

    private static int getScoreIfThreeSame(int[] cardNumCount) {
        for (int i = 1; i <= 9; i++) {
            if (cardNumCount[i] == 3) {
                return i + 400;
            }
        }

        return 0;
    }

    private static boolean isAllSameColor(Card[] cards) {
        Set<Character> set = new HashSet<>();
        for (Card card : cards) {
            set.add(card.color);
        }

        return set.size() == 1;
    }

    private static int isTwoSameAndTwoSame(int[] cardNumCount) {
        boolean isOneSame = false;
        boolean isTwoSame = false;

        int oneNum = 0;
        int twoNum = 0;
        for (int i = 1; i <= 9; i++) {
            if (cardNumCount[i] == 2) {
                if (!isOneSame) {
                    isOneSame = true;
                    oneNum = i;
                } else {
                    isTwoSame = true;
                    twoNum = i;
                }
            }
        }

        if (!(isOneSame && isTwoSame)) {
            return 0;
        }

        int max = Math.max(oneNum, twoNum);
        int min = Math.min(oneNum, twoNum);
        return max * 10 + min + 300;
    }

    private static int isTwoSame(int[] cardNumCount) {
        for (int i = 1; i <= 9; i++) {
            if (cardNumCount[i] == 2) {
                return i + 200;
            }
        }
        return 0;
    }

    private static int getMaxNum(Card[] cards) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Card card : cards) {
            pq.offer(card.num);
        }

        return pq.poll();
    }

    static class Card {

        char color;
        int num;

        public Card(char color, int num) {
            this.color = color;
            this.num = num;
        }
    }
}