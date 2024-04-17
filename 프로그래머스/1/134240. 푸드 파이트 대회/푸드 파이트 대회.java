import java.util.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<food.length; i++) {
            int foodNum = food[i];
            if(foodNum != 1) {
                if(foodNum % 2 != 0) foodNum--;
                for(int j=0; j<foodNum/2; j++) {
                    sb.append(i);
                }
            }
        }
        answer.append(sb).append(0);
        StringBuilder reverse = new StringBuilder(sb.reverse().toString());
        answer.append(reverse.toString());
        return answer.toString();
    }
}