import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int cnt = n / 4;
        for (int i = 0; i < cnt; i++) {
            sb.append("long" + " ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}