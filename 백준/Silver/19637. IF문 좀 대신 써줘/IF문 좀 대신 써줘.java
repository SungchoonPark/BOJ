import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String badge = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            map.put(i, badge);
            list.add(value);
        }

        for (int i = 0; i < m; i++) {
            int v = Integer.parseInt(br.readLine());

            int start = 0;
            int end = list.size() - 1;
            int result = list.size() - 1;;
            while(start <= end) {
                int mid = (start + end) / 2;

                if (list.get(mid) >= v) {
                    result = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            sb.append(map.get(result)).append("\n");
        }

        System.out.print(sb);
    }
}