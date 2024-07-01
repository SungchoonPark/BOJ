import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static boolean[] arr = new boolean[1_000_001];
    static boolean[] visited = new boolean[1_000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        era();
        int testNum = Integer.parseInt(br.readLine());


        for (int i = 0; i < testNum; i++) {
            int num = Integer.parseInt(br.readLine());
            int tmp = 0;
            List<Integer> list = findPrimes(num);
            Arrays.fill(visited, false);

            for (Integer integer : list) {
                if (arr[num - integer]) {
                    if (!(visited[num-integer] || visited[integer])) {
                        visited[num-integer] = true;
                        visited[integer] = true;
                        tmp++;
                    }
                }
            }
            sb.append(tmp).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void era() {
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        arr[2] = true;
        for(int i=2; i<=Math.sqrt(arr.length); i++) {
            if (arr[i]) {
                for(int j=i*i; j<arr.length; j+=i) {
                    arr[j] = false;
                }
            }
        }
    }

    private static List<Integer> findPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<=n; i++) {
            if (arr[i]) list.add(i);
        }
        return list;
    }
}
