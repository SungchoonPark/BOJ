import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        String kingPos = st.nextToken();
        String rockPos = st.nextToken();
        int kpos = getPos(kingPos.charAt(0));
        int dpos = getPos(rockPos.charAt(0));

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[9][9];
        arr[kingPos.charAt(1) - '0'][kpos] = 1;
        arr[rockPos.charAt(1) - '0'][dpos] = -1;

        int y = kingPos.charAt(1) - '0';
        int x = kpos;

        int ry = rockPos.charAt(1) - '0';
        int rx = dpos;

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            int commandIdx = getCommandIdx(command);

            int ny = y + dy[commandIdx];
            int nx = x + dx[commandIdx];
            if (nx >= 1 && ny >= 1 && nx <= 8 && ny <= 8) {
                if (arr[ny][nx] == -1) {
                    int dny = ry + dy[commandIdx];
                    int dnx = rx + dx[commandIdx];

                    if (dnx >= 1 && dny >= 1 && dnx <= 8 && dny <= 8) {
                        arr[y][x] = 0;
                        arr[ny][nx] = 1;
                        arr[dny][dnx] = -1;
                        y = ny;
                        x = nx;
                        ry = dny;
                        rx = dnx;
                    }
                } else {
                    arr[y][x] = 0;
                    arr[ny][nx] = 1;
                    y = ny;
                    x = nx;
                }
            }
        }

        System.out.println(getStringPos(y, x));
        System.out.print(getStringPos(ry, rx));
    }

    private static String getStringPos(int y, int x) {
        if (x == 1) {
            return "A" + y;
        } else if (x == 2) {
            return "B" + y;
        } else if (x == 3) {
            return "C" + y;
        } else if (x == 4) {
            return "D" + y;
        } else if (x == 5) {
            return "E" + y;
        } else if (x == 6) {
            return "F" + y;
        } else if (x == 7) {
            return "G" + y;
        } else if (x == 8) {
            return "H" + y;
        }
        return "";
    }

    private static int getPos(char c) {
        if (c == 'A') {
            return 1;
        } else if (c == 'B') {
            return 2;
        } else if (c == 'C') {
            return 3;
        } else if (c == 'D') {
            return 4;
        } else if (c == 'E') {
            return 5;
        } else if (c == 'F') {
            return 6;
        } else if (c == 'G') {
            return 7;
        } else if (c == 'H') {
            return 8;
        }
        return -1;
    }

    private static int getCommandIdx(String command) {
        if (command.equals("R")) {
            return 0;
        } else if (command.equals("L")) {
            return 1;
        } else if (command.equals("B")) {
            return 2;
        } else if (command.equals("T")) {
            return 3;
        } else if (command.equals("RT")) {
            return 4;
        } else if (command.equals("LT")) {
            return 5;
        } else if (command.equals("RB")) {
            return 6;
        } else if (command.equals("LB")) {
            return 7;
        }

        return -1;
    }
}