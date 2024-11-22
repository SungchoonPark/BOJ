import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        if (n == 1) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;

        int max = 0;

        int tmpMax = arr[0];
        while(end < n) {
            if (arr[end] <= tmpMax) {
                // 조건 충족 안함
                start = end;
                tmpMax = arr[start];
                end++;
            } else {
                // 조건 충족함
                tmpMax = arr[end++];
                max = Math.max(max, tmpMax - arr[start]);
            }
        }

        System.out.println(max);
    }
}