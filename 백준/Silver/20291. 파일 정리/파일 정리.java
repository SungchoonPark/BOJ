import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        Set<String> extds = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String file = br.readLine();

            String[] split = file.split("\\.");
            String etd = split[1];
            extds.add(etd);
            map.put(etd, map.getOrDefault(etd, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.addAll(extds);

        while(!pq.isEmpty()) {
            String ext = pq.poll();
            Integer cnt = map.get(ext);
            sb.append(ext).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }


}