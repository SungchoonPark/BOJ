import java.util.*;
class Solution {
    static StringBuilder sb;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // arr1과 arr2의 각 배열을 이진수 형태로 바꾸고
        // 4 -> (만약 n이 5면) -> 00100 이렇게!
        // 그러고나서 arr1과 arr2의 각 칸을 비교하면서
        // 둘 중 하나라도 1(벽)이면 벽해버리고 아니며 0
        // 그리고나서 돌면서 1은 #으로 0은 ' '으로 치환해서 출력
        String[] answer = new String[n];
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            list1.add(toBinary(arr1[i], n));
            list2.add(toBinary(arr2[i], n));
        }
        
        for(int i=0; i<n; i++) {
            String s1 = list1.get(i);
            String s2 = list2.get(i);
            sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                
                if(c1 == '1' || c2 == '1') {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    private String toBinary(int i, int n) {
        // 2로 계속 나누고 마지막부터 쭈루룩 올라가면 됨
        Stack<Integer> stack = new Stack<>();
        sb = new StringBuilder();
        
        while(i != 0) {
            stack.push(i%2);
            i /= 2;
        }
        
        int size = stack.size();
        if(size != n) {
            for(int a=0; a<n-size; a++) {
                stack.push(0);
            }
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}