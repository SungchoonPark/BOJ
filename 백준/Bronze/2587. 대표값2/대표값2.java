import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];

        int tmp = 0;
        for (int i = 0; i < 5; i++) {
            int a = Integer.parseInt(br.readLine());
            tmp += a;
            arr[i] = a;
        }

        Arrays.sort(arr);
        System.out.println(tmp / 5);
        System.out.println(arr[2]);
    }
}
