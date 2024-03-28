import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger[] arr = new BigInteger[501];

        arr[0] = BigInteger.ONE;
        arr[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1].multiply(BigInteger.valueOf(i));
        }

        String s = String.valueOf(arr[n]);

        int cnt = 0;
        for(int i=s.length() - 1; i>=0; i--) {
            if (s.charAt(i) == '0') cnt++;
            else break;
        }

        System.out.println(cnt);


    }
}
