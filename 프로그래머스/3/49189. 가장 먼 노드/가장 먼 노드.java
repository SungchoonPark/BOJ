import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new List[n + 1];
        visited = new boolean[n+1];
        
        for(int i=0; i<n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++) {
            int a1 = edge[i][0];
            int a2 = edge[i][1];
            
            graph[a1].add(a2);
            graph[a2].add(a1);
        }
        
        return bfs();
    }
    
    public int bfs() {
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(1, 1));
        int maxDepth = 1;
        int count = 0;
        visited[1] = true;
        
        while(!q.isEmpty()) {
            Info curInfo = q.poll();
            
            if(curInfo.depth == maxDepth) {
                count++;
            } else if(curInfo.depth > maxDepth) {
                maxDepth = curInfo.depth;
                count = 1;
            }
            
            for(int n : graph[curInfo.node]) {
                if(!visited[n]) {
                    visited[n] = true;
                    q.offer(new Info(n, curInfo.depth + 1));
                }
            }
        }
        return count;
    }
}

class Info {
    int node;
    int depth;
    
    public Info(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}