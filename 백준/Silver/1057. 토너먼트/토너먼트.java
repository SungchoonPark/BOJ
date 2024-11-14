import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int jNum = Integer.parseInt(st.nextToken());
        int iNum = Integer.parseInt(st.nextToken());

        int result = 0;
        while(iNum != jNum) {
            iNum -= iNum / 2;
            jNum -= jNum / 2;
            result++;
        }

        System.out.print(result);
    }
}