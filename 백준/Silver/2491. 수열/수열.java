import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int increase = 1;
        int decrease = 1;
        int maxIncrease = 0;
        int maxDecrease = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                increase++;
                decrease++;
                if (i == n - 2) {
                    if (increase > maxIncrease) maxIncrease = increase;
                    if (decrease > maxDecrease) maxDecrease = decrease;
                }
            }
            if (arr[i] > arr[i + 1]) {
                decrease++;
                if (i == n - 2) {
                    if (decrease > maxDecrease) maxDecrease = decrease;
                }
                if (increase > maxIncrease) maxIncrease = increase;
                increase = 1;
            }
            if (arr[i] < arr[i + 1]) {
                increase++;
                if (i == n - 2) {
                    if (increase > maxIncrease) maxIncrease = increase;
                }
                if (decrease > maxDecrease) maxDecrease = decrease;

                decrease = 1;
            }
        }
        if (increase == decrease) System.out.println(increase);
        else System.out.println(Math.max(maxIncrease, maxDecrease));
    }
}