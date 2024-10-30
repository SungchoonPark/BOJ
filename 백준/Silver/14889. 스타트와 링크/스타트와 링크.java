import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int result = Integer.MAX_VALUE;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[n + 1];
        comb(visited, 1, n, n / 2);

        System.out.print(result);
    }

    private static void comb(boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            // 모든 조합을 뽑았을 때 팀 구성
            int[] startTeam = new int[n / 2];
            int[] linkTeam = new int[n / 2];
            int stIdx = 0, liIdx = 0;

            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    startTeam[stIdx++] = i;
                } else {
                    linkTeam[liIdx++] = i;
                }
            }

            // 팀 내 조합으로 점수 계산
            int stScore = calcTeamScore(startTeam);
            int liScore = calcTeamScore(linkTeam);
            int diff = Math.abs(stScore - liScore);

            result = Math.min(diff, result);
            return;
        }

        for (int i = start; i <= n; i++) {
            visited[i] = true;
            comb(visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private static int calcTeamScore(int[] team) {
        int score = 0;
        for (int i = 0; i < team.length - 1; i++) {
            for (int j = i + 1; j < team.length; j++) {
                score += getTeamScore(team[i], team[j]);
            }
        }
        return score;
    }

    private static int getTeamScore(int i, int j) {
        return arr[i][j] + arr[j][i];
    }
}