import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int max = 0;
    static int maxIdx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        arr = new ArrayList[num + 1];

        for (int i = 0; i <= num; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < num - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parentNum = Integer.parseInt(st.nextToken());
            int childNum = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[parentNum].add(new Node(childNum, weight));
            arr[childNum].add(new Node(parentNum, weight));
        }
        visited = new boolean[num + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[num + 1];
        visited[maxIdx] = true;
        dfs(maxIdx, 0);

        System.out.println(max);
    }

    private static void dfs(int n, int cnt) {
        if(max < cnt) {
            max = cnt;
            maxIdx = n;
        }

        for (Node node : arr[n]) {
            if (!visited[node.nodeNum]) {
                visited[node.nodeNum] = true;
                dfs(node.nodeNum, cnt + node.weight);
            }
        }
    }
}

class Node {
    int nodeNum;
    int weight;

    public Node(int nodeNum, int weight) {
        this.nodeNum = nodeNum;
        this.weight = weight;
    }
}