import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1; ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            if(L == 0) break;
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int result = (V / P) * L + Math.min(V % P, L);

            System.out.println("Case "+i+": "+result);
        }


    }
}

