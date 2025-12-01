import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                int nextPerson = Integer.parseInt(br.readLine());

                arr[j] = nextPerson;
            }

            boolean isMeet = false;
            int idx = 1;
            for (int i1 = 1; i1 <= n; i1++) {
                if (arr[idx] == arr.length - 1) {
                    // 주경이 걸릴 수 있음
                    sb.append(i1).append("\n");
                    isMeet = true;
                    break;
                }
                idx = arr[idx];
            }

            if (!isMeet) {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }

}