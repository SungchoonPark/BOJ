import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testNum; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            boolean flag = false;
            for (int j =x; j<(M * N); j += M) {
                if (j % N ==  y) {
                    System.out.println(j + 1);
                    flag = true;
                    break;
                }
            }

            if (!flag) System.out.println(-1);
        }
    }
}