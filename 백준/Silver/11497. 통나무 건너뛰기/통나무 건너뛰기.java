import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            LinkedList<Integer> list = new LinkedList<>();
            boolean flag = false;
            for (int i1 : arr) {
                if (flag) {
                    list.addFirst(i1);
                } else {
                    list.addLast(i1);
                }
                flag = !flag;
            }

            sb.append(getMin(list)).append("\n");
        }

        System.out.print(sb);
    }

    private static int getMin(LinkedList<Integer> list) {
        int max = Integer.MIN_VALUE;

        max = Math.max(max, Math.abs(list.getFirst() - list.getLast()));

        for (int i = 0; i < list.size() - 1; i++) {
            Integer n1 = list.get(i);
            Integer n2 = list.get(i + 1);

            max = Math.max(max, Math.abs(n1 - n2));
        }

        return max;
    }
}