import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int testCaseNum = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Set<Integer> uniqueScores = new HashSet<>();
            Map<Integer, Integer> scoresCnt = new HashMap<>();
            while(st.hasMoreElements()) {
                int score = Integer.parseInt(st.nextToken());
                uniqueScores.add(score);
                scoresCnt.put(score, scoresCnt.getOrDefault(score, 0) + 1);
            }

            PriorityQueue<Integer> result = new PriorityQueue<>((n1, n2) -> n2 - n1);
            int maxCnt = 0;
            for (Integer uniqueScore : uniqueScores) {
                Integer scoreCnt = scoresCnt.get(uniqueScore);
                if (scoreCnt > maxCnt) {
                    maxCnt = scoreCnt;
                    result = new PriorityQueue<>((n1, n2) -> n2 - n1);
                    result.offer(uniqueScore);
                } else if (scoreCnt == maxCnt){
                    result.offer(uniqueScore);
                }
            }

            System.out.println("#" + (i+1) + " " + result.poll());
        }
    }
}