import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }
        
        int time = 0;
        int weightTmp = 0;
        int truckIdx = 0;
        while (truckIdx < truck_weights.length) {
            weightTmp -= queue.poll();

            int truckWeight = truck_weights[truckIdx];
            if (weightTmp + truckWeight <= weight) {
                queue.offer(truckWeight);
                truckIdx++;
                weightTmp += truckWeight;
            } else {
                queue.offer(0);
            }

            time++;
        }

        while(weightTmp > 0) {
            weightTmp -= queue.poll();
            time++;
        }

        return time;
    }
}