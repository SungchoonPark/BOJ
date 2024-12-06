import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static Set<String> uniques = new HashSet<>();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            search(visited, k-1, String.valueOf(arr[i]));
        }

        System.out.println(uniques.size());
    }

    private static void search(boolean[] visited, int r, String nums) {
        if (r == 0) {
            uniques.add(nums);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                search(visited, r-1, nums + arr[i]);
                visited[i] = false;
            }
        }
    }

}