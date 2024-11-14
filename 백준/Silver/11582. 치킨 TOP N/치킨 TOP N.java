import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i += (n / k)) {
            doSort(i, i + (n / k));
        }
        System.out.println(sb);
    }

    private static void doSort(int start, int end) {
        // 총 횟수
        int[] tmp = new int[end - start];
        for (int j = start; j < end; j++) {
            tmp[j - start] = arr[j];
        }

        Arrays.sort(tmp);

        for (int j = 0; j < tmp.length; j++) {
            sb.append(tmp[j]).append(" ");
        }
    }
}