import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            long tmp = Long.parseLong(st.nextToken());
            sb.append(binarySearch(tmp)).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(long tmp) {
        int stIdx = 0;
        int edIdx = arr.length - 1;

        while(stIdx <= edIdx) {
            int middle = (stIdx + edIdx) / 2;

            if (arr[middle] == tmp) {
                return 1;
            } else if (arr[middle] > tmp) {
                edIdx = middle - 1;
            } else if (arr[middle] < tmp) {
                stIdx = middle + 1;
            }
        }

        return 0;
    }
}
