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
        int[] copy = arr.clone();
        Arrays.sort(copy);

        Set<Integer> set = new HashSet<>();
        set.add(copy[0]);
        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                if (copy[i-1] != copy[i]) {
                    set.add(copy[i]);
                }
            } else {
                if (copy[i - 1] != copy[i] || copy[i + 1] != copy[i]) {
                    set.add(copy[i]);
                }
            }
        }
        int[] unique = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(unique);

        for (int i = 0; i < n; i++) {
            int value = arr[i];
            int bigCount = getBigCount(value, unique);
            sb.append(bigCount).append(" ");
        }

        System.out.print(sb);
    }

    private static int getBigCount(int value, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        int minIdx = -1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] < value) {
                minIdx = mid;
                start = mid + 1;
            } else if (arr[mid] >= value) {
                end = mid - 1;
            }
        }

        if (minIdx == -1) {
            return 0;
        }

        return minIdx + 1;
    }
}