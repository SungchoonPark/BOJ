import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int left = 0;
        int right = n - 1;
        int min = Math.abs(arr[right] + arr[left]);
        int ansLeft = arr[left];
        int ansRight = arr[right];
        while (left < right) {
            int tmp = Math.abs(arr[right] + arr[left]);

            if (min > tmp) {
                min = tmp;
                ansRight = arr[right];
                ansLeft = arr[left];
            }

            if (Math.abs(arr[right-1] + arr[left])  < tmp) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(ansLeft + " " + ansRight);
    }

}