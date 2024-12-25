import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int maxGap = 0;
            int cnt = Integer.parseInt(st.nextToken());
            int[] arr = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            for (int i1 = 0; i1 < arr.length; i1++) {
                if (i1 != 0) {
                    int abs = Math.abs(arr[i1] - arr[i1 - 1]);
                    if (abs > maxGap) {
                        maxGap = abs;
                    }
                }
            }

            sb.append("Class ").append((i + 1)).append("\n");
            sb.append("Max ").append(arr[cnt - 1]).append(", Min ").append(arr[0]).append(", Largest gap ").append(maxGap).append("\n");

        }
        System.out.print(sb);
    }
}