import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()) - 1;
        int B = Integer.parseInt(st.nextToken()) - 1;

        int[] arr = new int[1035];
        
        int tmp = 0;
        for(int i=1; i<=45; i++) {
            for(int j=1; j<=i; j++) {
                arr[tmp] = i;
                tmp++;
            }
        }
        int sum = 0;
        for(int i=A; i<=B; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}

