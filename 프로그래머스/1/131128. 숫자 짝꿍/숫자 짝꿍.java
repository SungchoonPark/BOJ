import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        // 짝꿍이란 공통으로 나타나는 정수로 만들 수 있는 가장 큰 수
        // 짝꿍이 존재하지 않으면 짝꿍은 -1
        // 짝궁이 0으로만 구성되어 있다면 짝궁은 0
        
        // 일단 공통되는 숫자를 찾아내고 이를 저장해둠.
        // 공통되는 숫자들로 최대 숫자를 만들어내면 됨. -> 이건 걍 정렬해서 이어붙이면 될듯
        // 한번 돌면서 각 숫자들의 숫자들 파악
        int[] xarr = new int[10];
        int[] yarr = new int[10];
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : X.toCharArray()) {
            xarr[c - '0']++;
        }
        for(char c : Y.toCharArray()) {
            yarr[c - '0']++;
        }
        
        boolean onlyZero = true;
        int sum = 0;
        for(int i=9; i>=0; i--) {
            int iterNum = Math.min(xarr[i], yarr[i]);
            sum += iterNum;
            if(i > 0 && iterNum > 0) {
                onlyZero = false;
            }
            for(int j=0; j<iterNum; j++) {
                sb.append(i);
            }
        }
        if(sum == 0) return "-1";
        else if(onlyZero) return "0";
        return sb.toString();
    }
}