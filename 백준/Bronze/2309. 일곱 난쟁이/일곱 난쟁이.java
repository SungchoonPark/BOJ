import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> result = new ArrayList<>(7);
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = 0;
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j) sum+= arr[k];
                }

                if (sum == 100 ) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) result.add(arr[k]);
                    }
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        result.sort(Comparator.naturalOrder());
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}