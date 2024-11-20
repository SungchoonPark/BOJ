import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1~5 학년까지 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시반장으로
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][5];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        int stn = 0;
        for (int i = 0; i < n; i++) {
            // 학생 선택
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                int classN = arr[i][j];
                for (int k = 0; k < n; k++) {
                    if (k == i) continue;

                    if (arr[k][j] == classN) {
                        set.add(k);
                    }
                }
            }

            if (set.size() > max) {
                max = set.size();
                stn = (i+1);
            }
        }

        System.out.println(stn);
    }
}