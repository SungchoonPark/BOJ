import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int photoNum = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer[]> candidates = new HashMap<>();
        int inputTime = 1;
        while(st.hasMoreElements()) {
            int candidateNum = Integer.parseInt(st.nextToken());

            if (candidates.containsKey(candidateNum)) {
                Integer[] infos = candidates.get(candidateNum);
                infos[1]++;
                candidates.put(candidateNum, infos);
                continue;
            }

            if (candidates.isEmpty() || candidates.size() < photoNum) {
                // 사진첩 비어있는 경우
                candidates.put(candidateNum, new Integer[]{inputTime++, 0});
            } else {
                // 사진첩 꽉찬 경우
                List<Entry<Integer, Integer[]>> entries = new ArrayList<>(candidates.entrySet());
                entries.sort((e1, e2) -> {
                    int compare = e1.getValue()[1].compareTo(e2.getValue()[1]);

                    if (compare != 0) {
                        return compare;
                    } else {
                        return e1.getValue()[0].compareTo(e2.getValue()[0]);
                    }
                });

                Integer removeCandidateNum = entries.get(0).getKey();
                candidates.remove(removeCandidateNum);
                candidates.put(candidateNum, new Integer[]{inputTime++, 0});
            }
        }

        ArrayList<Integer> finalCandidates = new ArrayList<>(candidates.keySet());
        Collections.sort(finalCandidates);
        for (Integer finalCandidate : finalCandidates) {
            sb.append(finalCandidate).append(' ');
        }

        System.out.print(sb);
    }

}