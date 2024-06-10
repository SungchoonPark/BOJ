import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            if(n % i == 0) list.add(i);
        }

        try {
            System.out.println(list.get(m-1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(0);
        }

    }
}
