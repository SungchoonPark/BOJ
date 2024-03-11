class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : results) {
            // 인덱스는 0부터 시작이니까 1을 빼줌
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            // 이는 u는 v에게 항상 이긴다는 것
            graph[u][v] = true;
        }

        int count = 0;
        for(int u = 0; u<n; u++) {
            int wins = countForward(u, graph, new boolean[n]) - 1;
            int loses = countBackward(u, graph, new boolean[n]) - 1;
            if (wins + loses + 1 == n) {
                count++;
            }
        }

        return count;
    }

    private int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for(int v = 0; v < graph.length; v++) {
            if (!graph[v][u] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countBackward(v, graph, isVisited);
        }

        return count;
    }

    private int countForward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for(int v = 0; v < graph[u].length; v++) {
            if (!graph[u][v] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countForward(v, graph, isVisited);
        }

        return count;
    }
}