import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int findNum = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = arr.length - 1;

            while(start <= end) {
                int mid = (start + end) / 2;

                if (arr[mid] == findNum) {
                    sb.append(1).append("\n");
                    break;
                }

                if (arr[mid] > findNum) {
                    end = mid - 1;
                } else if (arr[mid] < findNum) {
                    start = mid + 1;
                }
            }
            if (start > end){
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }
}