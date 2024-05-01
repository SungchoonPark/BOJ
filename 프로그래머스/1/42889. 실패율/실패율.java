import java.util.*;

class Stage {
    int stageNum;
    double failRate;
    
    public Stage(int stageNum, double failRate) {
        this.stageNum = stageNum;
        this.failRate = failRate;
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
        List<Stage> stageList = new ArrayList<>();
        int[] arr = new int[N + 1];
        int total = stages.length;
        
        for(int i : stages) {
            if(i == N + 1) {
                continue;
            }
            arr[i]++;
        }
        
        for(int i=1; i<arr.length; i++) {
            int tmp = arr[i];
            double failRate;
            
            if(tmp == 0) {
                failRate = 0.0;
            } else {
                failRate = (double)arr[i] / total;
                total -= arr[i];
            }
            stageList.add(new Stage(i, failRate));
        }
        
        stageList.sort((s1, s2) -> {
            if(s1.failRate == s2.failRate) {
                return Integer.compare(s1.stageNum, s2.stageNum);
            }
            return Double.compare(s2.failRate, s1.failRate);
        });
        
        for(Stage s : stageList) {
            System.out.println("stageNum : " + s.stageNum + ", failRate : " + s.failRate);
        }
        
        int[] answer = new int[stageList.size()];
        for(int i=0; i<stageList.size(); i++) {
            answer[i] = stageList.get(i).stageNum;
        }
        return answer;
    }
}