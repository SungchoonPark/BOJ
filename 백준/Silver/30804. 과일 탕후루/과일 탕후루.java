import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n < 3) {
            System.out.println(n);
            return;
        }

        int max = 0;
        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 과일 종류와 개수를 저장하는 맵

        while (end < n) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[start], map.get(arr[start]) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }

            max = Math.max(max, end - start + 1);
            end++;
        }

        System.out.print(max);
    }
}