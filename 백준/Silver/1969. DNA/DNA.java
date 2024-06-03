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
        int[] alpha = new int[26];
        int answer = 0;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            for(int j=0; j<list.size(); j++) {
                char c = list.get(j).charAt(i);
                alpha[c - 'A']++;
            }

            int max = 0;
            char sMax = 'a';
            for(int k=0; k<alpha.length; k++) {
                if (alpha[k] > max) {
                    max = alpha[k];
                    sMax = (char)(k + 'A');
                }
            }
            answer += n - max;
            sb.append(sMax);
            Arrays.fill(alpha, 0);
        }
        sb.append("\n").append(answer);
        System.out.println(sb);
    }
}
