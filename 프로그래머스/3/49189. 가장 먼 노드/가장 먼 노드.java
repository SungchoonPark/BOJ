import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int result;
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        graph = new List[n + 1];
        visited = new boolean[n + 1];
        for(int i=0; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        visited[1] = true;
        bfs(1);
        
        return result;
    }
    
    private void bfs(int start) {
        Queue<NodeInfo> q = new LinkedList<>();
        q.add(new NodeInfo(start, 0));
        
        int maxDepth = -1;
        
        while(!q.isEmpty()) {
            NodeInfo curNode = q.poll();
            
            if(curNode.depth > maxDepth) {
                maxDepth = curNode.depth;
                result = 1;
            } else if(curNode.depth == maxDepth) {
                result++;
            }
            
            for(Integer a : graph[curNode.node]) {
                if(!visited[a]) {
                    visited[a] = true;
                    q.offer(new NodeInfo(a, curNode.depth + 1));
                }
            }
        }
    }
}

class NodeInfo {
    int node;
    int depth;
    
    public NodeInfo(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}