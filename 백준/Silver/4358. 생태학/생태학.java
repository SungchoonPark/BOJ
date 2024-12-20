import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int cnt = 0;
        TreeMap<String, Integer> map = new TreeMap<>();
        while(true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;
            cnt++;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String ratio = String.format("%.4f", (double)entry.getValue() / cnt * 100);
            sb.append(entry.getKey()).append(" ").append(ratio).append("\n");
        }

        System.out.print(sb);
    }
}