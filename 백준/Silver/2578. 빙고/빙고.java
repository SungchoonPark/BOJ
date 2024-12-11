import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static boolean[][] bingoMap;
    static int[][] resultMap;
    static Map<Integer, Pos> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        bingoMap = new boolean[5][5];
        resultMap = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, new Pos(j, i));
            }
        }

        List<Integer> resultNums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                resultNums.add(Integer.parseInt(st.nextToken()));
            }
        }

        int result = 0;
        for (Integer resultNum : resultNums) {
            // 수를 순서대로 부를거임, 그 수의 빙고판에서의 위치가 나옴
            Pos numPos = map.get(resultNum);
            result++;

            bingoMap[numPos.y][numPos.x] = true;
            if (getBingoCount() >= 3) {
                System.out.println(result);
                return;
            }
        }
    }

    private static int getBingoCount() {
        int bingoCount = 0;

        // 가로로 쫙 보기
        for (int i = 0; i < 5; i++) {
            if (
                    bingoMap[i][0] &&
                            bingoMap[i][1] &&
                            bingoMap[i][2] &&
                            bingoMap[i][3] &&
                            bingoMap[i][4]
            ) bingoCount++;
        }

        // 세로로 쫙 보기
        for (int i = 0; i < 5; i++) {
            if (
                    bingoMap[0][i] &&
                            bingoMap[1][i] &&
                            bingoMap[2][i] &&
                            bingoMap[3][i] &&
                            bingoMap[4][i]
            ) bingoCount++;
        }

        // 대각선 보기
        if (bingoMap[0][0] && bingoMap[1][1] && bingoMap[2][2] && bingoMap[3][3] && bingoMap[4][4])
            bingoCount++;

        // 대각선 보기
        if (bingoMap[0][4] && bingoMap[1][3] && bingoMap[2][2] && bingoMap[3][1] && bingoMap[4][0])
            bingoCount++;

        return bingoCount;
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}