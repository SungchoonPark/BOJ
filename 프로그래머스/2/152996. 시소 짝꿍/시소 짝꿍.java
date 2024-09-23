import java.util.*;
class Solution {
    static int[] arr;
    public long solution(int[] weights) {
        long answer = 0;
        arr = new int[100_001];
        
        for(int weight : weights) {
            arr[weight]++;
        }

        
        for(int weight : weights) {
            answer += getNum(weight);
        }
        
        return answer / 2;  // 각 짝이 두 번씩 계산되므로 2로 나누어 주어야 함
    }
    
    private static long getNum(int curNum) {
        long value = 0;
        double[] ratios = {1.0, 2.0, 0.5, 3.0/2.0, 2.0/3.0, 4.0/3.0, 3.0/4.0};  // 2:3, 2:4, 3:2, 3:4 등의 비율 포함
        
        for(double ratio : ratios) {
            if(!isValidNum(curNum, ratio)) continue;
            int matchingWeight = (int) (curNum * ratio);
            if(matchingWeight == curNum) {
                value += arr[matchingWeight] - 1;
            } else if (matchingWeight < 100_001) {
                value += arr[matchingWeight];
            }
        }
        
        return value;
    }
    
    private static boolean isValidNum(int curNum, double r) {
        double tmp = curNum * r;
        if(tmp == Math.floor(tmp)) return true;
        return false;
    }
}
