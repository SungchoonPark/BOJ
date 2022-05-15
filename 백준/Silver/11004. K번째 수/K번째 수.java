import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr.add(Integer.parseInt(st1.nextToken()));
        }
        
        Collections.sort(arr);
        System.out.println(arr.get(K-1));

    }
}

