import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static StringTokenizer st;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int minAnswer = 1;

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][column];

        int notZero = 0;
        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<column; j++) {
                int tmp =Integer.parseInt(st.nextToken());
                if(tmp != 0) notZero++;
                arr[i][j] = tmp;
            }
        }

        while(notZero != 0) {
            int[][] copyArr = deepCopy(arr);
            visit = new boolean[row][column];

            for(int i=0; i<row; i++) {
                for(int j=0; j<column; j++) {
                    if(arr[i][j] != 0) {
                        int aroundNum = search(copyArr, i, j);
                        if(aroundNum >= arr[i][j]) {
                            arr[i][j] = 0;
                            notZero--;
                            continue;
                        }
                        arr[i][j] -= aroundNum;
                    }
                }
            }
            
            int tmpNum = 0;
            for(int i=0; i<row; i++) {
                for(int j=0; j<column; j++) {
                    if(arr[i][j] != 0 && !visit[i][j]) {
                        tmpNum++;
                        visit[i][j] = true;
                        dfs(arr, new Pos(j, i));
                    }
                }
            }

            if(tmpNum >= 2) {
                System.out.println(minAnswer);
                return;
            }
            minAnswer++;
        }

        System.out.println(0);
    }

    private static void dfs(int[][] arr, Pos pos) {
        Stack<Pos> stack = new Stack<>();
        stack.push(pos);

        while(!stack.isEmpty()) {
            Pos curPos = stack.pop();

            for(int i=0; i<4; i++) {
                int newX = curPos.x + dx[i];
                int newY = curPos.y + dy[i];

                if(newX >= 0 && newX < arr[0].length && newY >= 0 && newY < arr.length) {
                    if(arr[newY][newX] !=0 && !visit[newY][newX]) {
                        visit[newY][newX] = true;
                        stack.push(new Pos(newX, newY));
                    }
                }
            }
        }
    }

    private static int search(int[][] arr, int i, int j) {
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int tmpX = j + dx[k];
            int tmpY = i + dy[k];
            if(arr[tmpY][tmpX] == 0) cnt++;
        }
        return cnt;
    }

    private static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = original[i].clone();
        }
        return result;
    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}