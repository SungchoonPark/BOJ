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

        int sum = 0;
        int result = 0;
        int i = 0;
        while (st.hasMoreTokens()) {
            String j = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(j, "+");
            while (st1.hasMoreTokens()) {
                int t = Integer.parseInt(st1.nextToken());
                if (i == 0) result += t;
                else sum += t;
            }
            i++;
        }
        System.out.println(result - sum);
    }
}