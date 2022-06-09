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
        int K = Integer.parseInt(st.nextToken());
        int max = 0;
        int index=10000;
        int result = 0;

        List<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            arr.add( Integer.parseInt(br.readLine()));
        }

//        Collections.reverse(arr);

        for (int i=0; i<arr.size(); i++) {
            int tmp = arr.get(i);
            if(K - tmp >= 0) {
                max = tmp;
                index = i;
            } else {
                break;
            }
        }

        result += K / max;
        K %= max;

        for(int i = index-1; i >= 0 ; i--) {
            int a = K / arr.get(i);
            result += a;
            K %= arr.get(i);
            if(K == 0) break;
        }

        System.out.println(result);

    }
}

