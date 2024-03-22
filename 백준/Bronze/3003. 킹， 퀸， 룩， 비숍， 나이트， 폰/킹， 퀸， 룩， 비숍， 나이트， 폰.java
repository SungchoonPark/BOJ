import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        sb.append(1 - Integer.parseInt(st.nextToken()) + " ");
        sb.append(1 - Integer.parseInt(st.nextToken()) + " ");
        sb.append(2 - Integer.parseInt(st.nextToken()) + " ");
        sb.append(2 - Integer.parseInt(st.nextToken()) + " ");
        sb.append(2 - Integer.parseInt(st.nextToken()) + " ");
        sb.append(8 - Integer.parseInt(st.nextToken()) + " ");
        System.out.println(sb);
    }

}