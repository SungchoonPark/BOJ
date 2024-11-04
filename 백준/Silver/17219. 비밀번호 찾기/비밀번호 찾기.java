import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> pwd = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String site = st.nextToken();
            String pass = st.nextToken();

            pwd.put(site, pass);
        }

        for (int i = 0; i < m; i++) {
            String needSite = br.readLine();
            sb.append(pwd.get(needSite)).append("\n");
        }

        System.out.print(sb);
    }
}