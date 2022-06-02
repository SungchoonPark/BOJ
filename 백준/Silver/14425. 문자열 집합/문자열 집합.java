import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        Set<String> strings = new HashSet<>();
        for(int i=0; i<N; i++) {
            strings.add(br.readLine());
        }

        for(int i=0; i<M; i++) {
            String tmp = br.readLine();

            if(strings.contains(tmp)) {
                result++;
            }
        }

        System.out.println(result);
    }
}

