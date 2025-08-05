import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;
    static int width, height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        Map<Integer, Pos> storeInfos = new HashMap<>();
        int storeCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < storeCount; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            Pos posByDir = getPosByDir(dir, pos);
            storeInfos.put(i + 1, posByDir);
        }

        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int pos = Integer.parseInt(st.nextToken());
        Pos dongPos = getPosByDir(dir, pos);

        int sum = 0;
        for(int i=1; i<=storeCount; i++) {
            Pos storePos = storeInfos.get(i);

            if (dongPos.dir == 1) {
                // 동근이가 북쪽에 있는 경우
                if (storePos.dir == 1) {
                    sum += Math.abs(storePos.x - dongPos.x);
                } else if (storePos.dir == 2) {
                    sum += height;
                    sum += Math.min(
                        (width - storePos.x) + (width - dongPos.x),
                        storePos.x + dongPos.x
                    );
                } else if (storePos.dir == 3) {
                    // 가게는 서쪽 -> 서쪽으로 이동하면됨
                    sum += (dongPos.x + storePos.y);
                } else if (storePos.dir == 4) {
                    // 가게는 동쪽 -> 동쪽으로 이동하면 됨
                    sum += ((width - dongPos.x) + storePos.y);
                }
            } else if (dongPos.dir == 2) {
                // 동근이 남쪽에 있는 경우
                if (storePos.dir == 1) {
                    sum += height;
                    sum += Math.min(
                        (width - storePos.x) + (width - dongPos.x),
                        storePos.x + dongPos.x
                    );
                } else if (storePos.dir == 2) {
                    sum += Math.abs(storePos.x - dongPos.x);
                } else if (storePos.dir == 3) {
                    // 가게는 서쪽 -> 서쪽으로 이동하면됨
                    sum += (dongPos.x + (height - storePos.y));
                } else if (storePos.dir == 4) {
                    // 가게는 동쪽 -> 동쪽으로 이동하면 됨
                    sum += ((width - dongPos.x) + (height - storePos.y));
                }
            } else if (dongPos.dir == 3) {
                // 동근이 서쪽에 있는 경우
                if (storePos.dir == 1) {
                    // 가게는 북쪽 -> 북쪽으로 이동하면됨
                    sum += (dongPos.y + storePos.x);
                } else if (storePos.dir == 2) {
                    // 가게는 남쪽 -> 남쪽으로 이동하면됨
                    sum += ((height - dongPos.y) + storePos.x);
                } else if (storePos.dir == 3) {
                    // 가게는 서쪽 -> 서쪽으로 이동하면됨
                    sum += Math.abs(storePos.y - dongPos.y);
                } else if (storePos.dir == 4) {
                    // 가게는 동쪽 -> 동쪽으로 이동하면 됨
                    sum += width;
                    sum += Math.min(
                        (height - storePos.y) + (height - dongPos.y),
                        storePos.y + dongPos.y
                    );
                }
            } else if (dongPos.dir == 4) {
                // 동근이 동쪽에 있는 경우
                if (storePos.dir == 1) {
                    // 가게는 북쪽 -> 북쪽으로 이동하면됨
                    sum += (dongPos.y + (width - storePos.x));
                } else if (storePos.dir == 2) {
                    // 가게는 남쪽 -> 남쪽으로 이동하면됨
                    sum += ((height - dongPos.y) + (width - storePos.x));
                } else if (storePos.dir == 3) {
                    // 가게는 서쪽 -> 서쪽으로 이동하면됨
                    sum += width;
                    sum += Math.min(
                        (height - storePos.y) + (height - dongPos.y),
                        storePos.y + dongPos.y
                    );
                } else if (storePos.dir == 4) {
                    // 가게는 동쪽 -> 동쪽으로 이동하면 됨
                    sum += Math.abs(storePos.y - dongPos.y);
                }
            }
        }

        System.out.println(sum);
    }

    private static Pos getPosByDir(int dir, int pos) {
        if (dir == 1) {
            return new Pos(dir,pos, 0);
        } else if (dir == 2) {
            return new Pos(dir, pos, height);
        } else if (dir == 3) {
            return new Pos(dir, 0, pos);
        } else {
            return new Pos(dir, width, pos);
        }
    }

    static class Pos {
        int dir;
        int x;
        int y;

        public Pos(int dir, int x, int y) {
            this.dir = dir;
            this.x = x;
            this.y = y;
        }
    }

}