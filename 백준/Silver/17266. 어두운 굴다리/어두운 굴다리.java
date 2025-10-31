import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int length;
    static int count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());
        count = Integer.parseInt(br.readLine());
        arr = new int[count];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1;
        int end = 100_000;

        while(start < end) {
            int middle = (start + end) / 2;

            if(can(middle)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        System.out.println(end);
    }

    private static boolean can(int h) {
        int prev = 0;
        for (int i : arr) {
            int left = Math.max(0, i - h);
            int right = Math.min(length, i + h);

            if (left > prev) return false;
            else if (left <= prev) {
                prev = right;
            }
        }

        return prev == length;
    }
}