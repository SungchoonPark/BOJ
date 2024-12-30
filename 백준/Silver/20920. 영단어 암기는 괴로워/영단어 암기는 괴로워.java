import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Word> pq = new PriorityQueue<>((w1, w2) -> {
            if (w1.count == w2.count) {
                if (w1.value.length() == w2.value.length()) {
                    return w1.value.compareTo(w2.value);
                }
                return w2.value.length() - w1.value.length();

            } else {
                return w2.count - w1.count;
            }
        });

        for (String s : map.keySet()) {
            Integer cnt = map.get(s);
            pq.add(new Word(s, cnt));
        }

        while(!pq.isEmpty()) {
            sb.append(pq.poll().value).append("\n");
        }
        System.out.print(sb);
    }

    static class Word {
        String value;
        Integer count;

        public Word(String value, Integer count) {
            this.value = value;
            this.count = count;
        }
    }
}