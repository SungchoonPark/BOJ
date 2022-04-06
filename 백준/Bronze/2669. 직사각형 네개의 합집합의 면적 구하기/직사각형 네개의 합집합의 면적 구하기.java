import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[101][101];
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int q = y1; q < y2; q++) {
                    if (arr[j][q] == 1) {
                        continue;
                    } else {
                        arr[j][q] = 1;
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}

