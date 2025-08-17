import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static int n, m;
    static int[][] map;

    static Map<Integer, List<String>> dirMap = new HashMap<>();
    static List<List<Integer>> comb = new ArrayList<>();
    static List<CCTV> cctvs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        dirMap.put(1, List.of("right", "down", "left", "up"));
        dirMap.put(2, List.of("left,right", "up,down", "left,right", "up,down"));
        dirMap.put(3, List.of("up,right", "right,down", "left,down", "left,up"));
        dirMap.put(4, List.of("left,up,right", "up,right,down", "right,down,left", "down,left,up"));
        dirMap.put(5, List.of("left,up,right,down", "left,up,right,down", "left,up,right,down",
            "left,up,right,down"));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 1 || value == 2 || value == 3 || value == 4 || value == 5) {
                    cctvs.add(new CCTV(i, j, value));
                }
            }
        }

        // 모든 조합 구하기
        bruteForce(0, new ArrayList<>(), cctvs.size());

        int minBlockArea = Integer.MAX_VALUE;
        for (List<Integer> combList : comb) {
            // 1. 모든 CCTV에 방향 설정 (이건 조합을 구한대로 방향 설정)
            for (int i = 0; i < cctvs.size(); i++) {
                // cctv 리스트중에 순차적으로 하나씩 가져오기
                CCTV curCCTV = cctvs.get(i);
                // 조합에서 순차적으로 현재 cctv에 dir 순서 할당
                curCCTV.setDir(combList.get(i));
            }

            int[][] cloneMap = new int[n][m];
            for (int j = 0; j < n; j++) {
                cloneMap[j] = map[j].clone();
            }

            // 2. 해당 방향을 정해준 후 맵 채우기
            fill(cloneMap);

            // 3. 사각지대 개수 구하기
            minBlockArea = Math.min(minBlockArea, countBlockArea(cloneMap));

        }

        System.out.println(minBlockArea);
    }

    private static void bruteForce(int depth, List<Integer> path, int limitSize) {
        if (path.size() == limitSize) {
            comb.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= 4; i++) {
            path.add(i);
            bruteForce(depth + 1, path, limitSize);
            path.remove(path.size() - 1);
        }
    }

    private static void fill(int[][] map) {
        for (CCTV cctv : cctvs) {
            String dirString = dirMap.get(cctv.num).get(cctv.dir - 1);
            String[] dirArr = dirString.split(",");

            for (String s : dirArr) {
                if (s.equals("left")) {
                    int curY = cctv.y;
                    int curX = cctv.x;

                    while(true) {
                        if (curX - 1 < 0 || map[curY][curX - 1] == 6) {
                            break;
                        }

                        if (map[curY][curX - 1] == 0) {
                            map[curY][curX - 1] = -1;
                        }
                        curX--;
                    }
                } else if (s.equals("right")) {
                    int curY = cctv.y;
                    int curX = cctv.x;

                    while(true) {
                        if (curX + 1 >= m || map[curY][curX + 1] == 6) {
                            break;
                        }

                        if (map[curY][curX + 1] == 0) {
                            map[curY][curX + 1] = -1;
                        }
                        curX++;
                    }
                } else if (s.equals("up")) {
                    int curY = cctv.y;
                    int curX = cctv.x;

                    while(true) {
                        if (curY - 1 < 0 || map[curY - 1][curX] == 6) {
                            break;
                        }

                        if (map[curY - 1][curX] == 0) {
                            map[curY- 1][curX] = -1;
                        }
                        curY--;
                    }
                } else if (s.equals("down")) {
                    int curY = cctv.y;
                    int curX = cctv.x;

                    while(true) {
                        if (curY + 1 >= n || map[curY + 1][curX] == 6) {
                            break;
                        }

                        if (map[curY + 1][curX] == 0) {
                            map[curY + 1][curX] = -1;
                        }
                        curY++;
                    }
                }
            }
        }
    }

    private static int countBlockArea(int[][] map) {
        int blockArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) blockArea++;
            }
        }

        return blockArea;
    }


    static class CCTV {

        int y;
        int x;
        int num;
        int dir;

        public CCTV(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
            this.dir = -1;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "CCTV{" +
                "y=" + y +
                ", x=" + x +
                ", num=" + num +
                '}';
        }
    }
}