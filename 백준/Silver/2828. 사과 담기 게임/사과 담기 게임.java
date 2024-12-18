import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int j = Integer.parseInt(br.readLine());

        int leftEnd = 1;
        int rightEnd = m;
        int result = 0;
        for (int i = 0; i < j; i++) {
            int pos = Integer.parseInt(br.readLine());

            if (pos > rightEnd) {
                result += pos - rightEnd;
                rightEnd = pos;
                leftEnd = rightEnd - m + 1;
            } else if (pos < leftEnd) {
                result += leftEnd - pos;
                leftEnd = pos;
                rightEnd = leftEnd + m - 1;
            }
        }

        System.out.println(result);
    }
}