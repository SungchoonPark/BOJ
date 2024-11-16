import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static int max, chance;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            chance = Integer.parseInt(st.nextToken());
            arr = String.valueOf(num).toCharArray();
            
            chance = Math.min(chance, String.valueOf(num).length());
            max = 0;
            dfs(0, 0);

            System.out.println("#" + (i + 1) + " " + max);
        }

    }

    private static void dfs(int start, int depth) {
        if (depth == chance) {
            String tmp = "";
            for (char c : arr) {
                tmp += c;
            }

            max = Math.max(max, Integer.parseInt(tmp));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                dfs(i, depth + 1);

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}