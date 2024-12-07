import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> dances = new HashSet<>();
        dances.add("ChongChong");
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            if (dances.contains(a) || dances.contains(b)) {
                dances.add(a);
                dances.add(b);
            }
        }

        System.out.println(dances.size());
    }
}