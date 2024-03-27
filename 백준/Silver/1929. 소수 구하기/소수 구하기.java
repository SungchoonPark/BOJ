import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[1000001];
        arr[0] = arr[1] = true;
        for (int i = 2; i <= 1000000; i++) {
            if (arr[i]) continue;
            for (int j = i * 2; j <= 1000000; j += i) {
                if (!arr[j]) arr[j] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for (int i = start; i<=end; i++) {
            if (!arr[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}