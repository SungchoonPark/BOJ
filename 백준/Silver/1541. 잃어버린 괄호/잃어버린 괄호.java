import javax.management.BadBinaryOpValueExpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String tmp = br.readLine();

        StringTokenizer st = new StringTokenizer(tmp, "-");

        int result = Integer.MAX_VALUE;
        while (st.hasMoreTokens()) {
            int sum = 0;
            String j = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(j, "+");
            while (st1.hasMoreTokens()) {
                sum += Integer.parseInt(st1.nextToken());
            }
            if(result == Integer.MAX_VALUE) result = sum;
            else result -= sum;
        }
        System.out.println(result);
    }
}