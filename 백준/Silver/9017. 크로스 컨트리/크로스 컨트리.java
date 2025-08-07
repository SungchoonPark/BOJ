import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());

            Map<Integer, List<Integer>> teamScore = new HashMap<>();
            int[] teamCount = new int[201];
            int[] inputs = new int[num];
            st = new StringTokenizer(br.readLine());

            int a = 0;
            while (st.hasMoreElements()) {
                int team = Integer.parseInt(st.nextToken());
                teamCount[team]++;
                inputs[a++] = team;
            }

            int score = 1;
            for (int j = 0; j < inputs.length; j++) {
                if (teamCount[inputs[j]] <= 5) {
                    continue;
                }

                List<Integer> teamScores = teamScore.getOrDefault(inputs[j], new ArrayList<>());
                teamScores.add(score++);
                teamScore.put(inputs[j], teamScores);
            }

            Map<Integer, Integer> teamMaxScore = new HashMap<>();

            Set<Integer> teams = teamScore.keySet();
            for (Integer team : teams) {
                List<Integer> scores = teamScore.get(team);
                Collections.sort(scores);
                int max = scores.get(0) + scores.get(1) + scores.get(2) + scores.get(3);
                teamMaxScore.put(team, max);
            }

            ArrayList<Entry<Integer, Integer>> entries = new ArrayList<>(teamMaxScore.entrySet());

            entries.sort((e1, e2) -> {
                int compareValue = e1.getValue().compareTo(e2.getValue());
                if (compareValue != 0) {
                    return compareValue;
                } else {
                    Integer t1 = e1.getValue() + teamScore.get(e1.getKey()).get(4);
                    Integer t2 = e2.getValue() + teamScore.get(e2.getKey()).get(4);

                    return t1.compareTo(t2);
                }
            });

            sb.append(entries.get(0).getKey()).append("\n");
        }

        System.out.print(sb);
    }

}