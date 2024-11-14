import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] friends;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        friends = new char[n][n];

        // 입력을 받기
        for (int i = 0; i < n; i++) {
            friends[i] = br.readLine().toCharArray();
        }

        int maxFriends = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && friends[i][j] == 'Y') {
                    if (!visited[j]) {
                        visited[j] = true;
                        count++;
                    }

                    for (int k = 0; k < n; k++) {
                        if (k != i && friends[j][k] == 'Y' && !visited[k]) {
                            visited[k] = true;
                            count++;
                        }
                    }
                }
            }
            maxFriends = Math.max(maxFriends, count);
        }

        System.out.println(Math.max(maxFriends, maxFriends - 1));
    }
}