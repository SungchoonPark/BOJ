import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] arr = new int[a];
            int[] brr = new int[b];

            st = new StringTokenizer(br.readLine());
            for (int i1 = 0; i1 < a; i1++) {
                arr[i1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i1 = 0; i1 < b; i1++) {
                brr[i1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(brr);

            int result = 0;
            for (int i1 = 0; i1 < arr.length; i1++) {
                int value = arr[i1];

                int start = 0;
                int end = b - 1;
                int cnt = 0;
                while(start <= end) {
                    int middle = (start + end) / 2;

                    if (brr[middle] >= value) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                        cnt = middle + 1;
                    }
                }
                result += cnt;
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}