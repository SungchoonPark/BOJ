import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1~5 학년까지 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시반장으로
        int switchCnt = Integer.parseInt(br.readLine());

        int[] switchs = new int[switchCnt + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCnt; i++) {
            switchs[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int rs = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                // 남학생인 경우
                for (int j = rs; j < switchCnt + 1; j++) {
                    if (j % rs == 0) {
                        switchs[j] = switchs[j] == 1 ? 0 : 1;
                    }
                }
            } else {
                int maxLen = Math.min(rs - 1, switchCnt - rs);
                switchs[rs] = switchs[rs] == 1 ? 0 : 1;
                for (int j = 1; j <= maxLen; j++) {
                    if (switchs[rs - j] == switchs[rs + j]) {
                        switchs[rs - j] = switchs[rs - j] == 1 ? 0 : 1;
                        switchs[rs + j] = switchs[rs + j] == 1 ? 0 : 1;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= switchCnt; i++) {
            System.out.print(switchs[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}