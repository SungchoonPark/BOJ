import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N+1];

        arr[0] = true;
        arr[1] = true;
        int tmp = 0;

        for(int i=2; i<= N; i++) {
            for(int j=i; j<=N; j+=i) {
                if(!arr[j]) {
                    tmp++;
                    arr[j] = true;
                }
                if(tmp == K) {
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }
    }
}
