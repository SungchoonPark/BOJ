import java.io.*;
import java.util.*;

public class Main {
    static int emoticon;
    static int[][] visit; // [screen][clipboard]
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        emoticon = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        visit = new int[1050][1050];
        for (int i = 0; i < 1050; i++) {
            Arrays.fill(visit[i], 9999);
        }

        bfs();
        System.out.print(sb);
    }

    private static void bfs() {
        Queue<Emo> q = new LinkedList<>();
        q.offer(new Emo(1, 0, 0));
        visit[1][0] = 0;

        while (!q.isEmpty()) {
            Emo curEmo = q.poll();

            if (curEmo.screen == emoticon) {
                sb.append(curEmo.time);
                return;
            }

            // 연산
            // 1. 화면에 존재하는 이모티콘 모두 복사하여 클립보드에 저장
            // 기존 내용은 덮어쓰기가 됨
            if (visit[curEmo.screen][curEmo.screen] >= curEmo.time + 1) {
                visit[curEmo.screen][curEmo.screen] = curEmo.time + 1;
                q.offer(new Emo(curEmo.screen, curEmo.screen, curEmo.time + 1));
            }

            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            // 단, 클립보드가 비어있으면 (clipboard == 0) 붙여넣기 할 수 없음
            // 붙여넣기 하면 클립보드의 개수만큼 화면에 추가가됨
            if (curEmo.clipboard != 0 && curEmo.screen + curEmo.clipboard < 1050) {
                if (visit[curEmo.screen + curEmo.clipboard][curEmo.clipboard] >= curEmo.time + 1) {
                    visit[curEmo.screen + curEmo.clipboard][curEmo.clipboard] = curEmo.time + 1;
                    q.offer(new Emo(curEmo.screen + curEmo.clipboard, curEmo.clipboard, curEmo.time + 1));
                }
            }

            // 3. 화면에 있는 이모티콘 하나 삭제
            if (curEmo.screen >= 1) {
                if (visit[curEmo.screen - 1][curEmo.clipboard] >= curEmo.time + 1) {
                    visit[curEmo.screen - 1][curEmo.clipboard] = curEmo.time + 1;
                    q.offer(new Emo(curEmo.screen - 1, curEmo.clipboard, curEmo.time + 1));
                }
            }
        }
    }

    static class Emo {
        int screen;
        int clipboard;
        int time;

        public Emo(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
}
