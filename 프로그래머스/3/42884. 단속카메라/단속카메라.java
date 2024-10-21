import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<Car> pq = new PriorityQueue<>((c1, c2) -> c1.output - c2.output);
        for(int i=0; i<routes.length; i++) {
            pq.offer(new Car(i, routes[i][0], routes[i][1]));
        }
        
//         while(!pq.isEmpty()) {
//             Car curCar = pq.poll();
            
//             System.out.println("carNum : " + curCar.carNum + ", input : " + curCar.input + ", output : " + curCar.output);
//         }
        
        int result = 0;
        while(!pq.isEmpty()) {
            Car curCar = pq.poll();
            
            while(!pq.isEmpty() && pq.peek().input <= curCar.output) {
                pq.poll();
            }
            result++;
        }
        return result;
    }
    
    static class Car {
        int carNum;
        int input;
        int output;
        
        public Car(int carNum, int input, int output) {
            this.carNum = carNum;
            this.input = input;
            this.output = output;
        }
    }
}