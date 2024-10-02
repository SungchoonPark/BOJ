import java.util.*;
class Solution {
    static String[][] arr;
    static boolean[][] isVisited;  // 방문 여부 추적 배열
    static int startX;
    static int startY;
    static int goalX;
    static int goalY;

    public int solution(String[] board) {
        arr = new String[board.length][board[0].length()];
        isVisited = new boolean[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            String[] tmps = board[i].split("");
            for (int j = 0; j < tmps.length; j++) {
                String tmp = tmps[j];
                if (tmp.equals("R")) {
                    startX = j;
                    startY = i;
                } else if (tmp.equals("G")) {
                    goalX = j;
                    goalY = i;
                }
                arr[i][j] = tmp;
            }
        }

        return bfs();
    }

    private static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(startX, startY, 0, -1));
        isVisited[startY][startX] = true;  // 시작점 방문 처리

        while (!q.isEmpty()) {
            Pos curPos = q.poll();
            int curX = curPos.x;
            int curY = curPos.y;

            // 목표 지점 도착
            if (curX == goalX && curY == goalY) {
                return curPos.cnt;
            }

            // 미끄러지듯 이동해야함.
            for (int dir = 0; dir < 4; dir++) {
                if (dir == curPos.dir) continue;
                int nx = curX;
                int ny = curY;

                while (true) {
                    // 방향에 따라 미끄러지듯 이동
                    if (dir == 0) ny--;       // 상
                    else if (dir == 1) ny++;  // 하
                    else if (dir == 2) nx--;  // 좌
                    else if (dir == 3) nx++;  // 우

                    // 배열 범위를 벗어나는지 확인
                    if (nx < 0 || nx >= arr[0].length || ny < 0 || ny >= arr.length) {
                        nx = Math.max(0, Math.min(nx, arr[0].length - 1));
                        ny = Math.max(0, Math.min(ny, arr.length - 1));
                        if (!isVisited[ny][nx]) {
                            isVisited[ny][nx] = true;
                            q.offer(new Pos(nx, ny, curPos.cnt + 1, dir));
                        }
                        break;
                    }

                    // 장애물 'D'를 만난 경우 처리
                    if (arr[ny][nx].equals("D")) {
                        if (dir == 0) ny++;
                        else if (dir == 1) ny--;
                        else if (dir == 2) nx++;
                        else if (dir == 3) nx--;
                        if (!isVisited[ny][nx]) {
                            isVisited[ny][nx] = true;
                            q.offer(new Pos(nx, ny, curPos.cnt + 1, dir));
                        }
                        break;
                    }
                }
            }
        }
        return -1;  // 도착할 수 없을 때
    }

    static class Pos {
        int x;
        int y;
        int cnt;
        int dir;

        public Pos(int x, int y, int cnt, int dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
}
