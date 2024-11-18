import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String word = br.readLine();
        int length = word.length();

        // 알파벳별 누적합 배열을 저장할 map
        Map<Character, int[]> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new int[length + 1]);
        }

        // 문자열을 순회하며 누적합 갱신
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);

            // 현재 문자의 누적합을 1 증가
            for (char key = 'a'; key <= 'z'; key++) {
                int[] prefixSum = map.get(key);
                prefixSum[i + 1] = prefixSum[i] + (key == c ? 1 : 0);
            }
        }

        // 입력받은 질의 처리
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char w = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int[] prefixSum = map.get(w);
            // s와 e는 0-based index로 들어오므로, 누적합을 계산할 때는 그대로 사용
            int result = prefixSum[e + 1] - prefixSum[s];
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}