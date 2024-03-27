import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int count = 0;
        boolean[] arr = new boolean[1001];
        arr[0] = arr[1] = true; 
        for (int i = 2; i <= 1000; i++) {
            if (arr[i]) continue;
            for (int j = i * 2; j <= 1000; j += i) {
                if (!arr[j]) arr[j] = true;
            }
        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            if (!arr[i]) count++;
        }
        System.out.println(count);
    }
}