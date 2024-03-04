import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] oneCnt = new int[41];
    private static int[] zeroCnt = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        oneCnt[0] = 0;
        zeroCnt[0] = 1;
        oneCnt[1] = 1;
        zeroCnt[1] = 0;
        for(int i=2; i<=40; i++) {
            oneCnt[i] = oneCnt[i-1] + oneCnt[i-2];
            zeroCnt[i] = zeroCnt[i-1] + zeroCnt[i-2];
        }

        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(zeroCnt[a] + " " + oneCnt[a]);
        }
    }
}