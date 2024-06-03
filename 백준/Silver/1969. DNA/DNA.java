import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            map.put("A", 0);
            map.put("T", 0);
            map.put("G", 0);
            map.put("C", 0);
            for (String s : list) {
                String tmp = String.valueOf(s.charAt(i));
                map.put(tmp, map.get(tmp) + 1);
            }

            int max = 0;
            String sMax = "";
            for (String s : map.keySet()) {
                int num = map.get(s);
                if (num > max || (num == max && s.compareTo(sMax) < 0)) {
                    max = num;
                    sMax = s;
                }
            }
            answer += n - max;
            sb.append(sMax);
        }
        sb.append("\n").append(answer);
        System.out.println(sb);
    }
}
