import java.util.*;

class Solution {
    static List<Integer>[] arr;
    public int solution(int n, int[][] wires) {
        // 전력망을 나눴을 때 두 전력망의 송전탑 개수의 차이(절대값) 출력
        int answer = 9999;
        
        arr = new List[n + 1];
        for(int i=0; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }
        
        // 트리 구조 만들기
        for(int[] tmpi : wires) {
            int v1 = tmpi[0];
            int v2 = tmpi[1];
            
            arr[v1].add(v2);
            arr[v2].add(v1);
        }
//         for(int i=1; i<=n; i++) {
//             System.out.println("[현재 인덱스] : " + i);
            
//             for(Integer tmp : arr[i]) {
//                 System.out.println("[원소값] : " + tmp);
//             }
//         }
        // System.out.println();
        
        // 전선 하나씩 끊어보기
        for(int[] tmpi : wires) {
            Integer v1 = tmpi[0];
            Integer v2 = tmpi[1];
            // System.out.println("[문제없음 - 1]");
            arr[v1].remove(v2);
            arr[v2].remove(v1);
            // System.out.println("[문제없음 - 2]");
            boolean[] isVisited = new boolean[n + 1];
            boolean isFirst = true;
            int tmpDiff = 0;
            for(int i=1; i<=n; i++) {
                if(!isVisited[i]) {
                    int tmp = dfs(n, i, isVisited);
                    // System.out.println("[첫번째임?] : " + isFirst);
                    // System.out.println("[DFS 결과] : " + tmp);
                
                    if(isFirst) {
                        tmpDiff += tmp;
                        isFirst = false;
                    } else {
                        tmpDiff -= tmp;
                    }
                }
            }
            // System.out.println("[전력망 탑 차이 수] : " + Math.abs(tmpDiff));
            System.out.println();
            answer = Math.min(Math.abs(tmpDiff), answer);
            arr[v1].add(v2);
            arr[v2].add(v1);
        }
        
        return answer;
    }
    
    // 두 전력망 사이의 탑의 개수 차이 return
    private static int dfs(int n, int startN, boolean[] isVisited) {
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        stack.push(startN);
        isVisited[startN] = true;

        while(!stack.isEmpty()) {
            Integer curN = stack.pop();

            for(Integer tmp : arr[curN]) {
                if(!isVisited[tmp]) {
                    isVisited[tmp] = true;
                    num++;
                    stack.push(tmp);
                }
            }
        }
        
        return num;
    }
}