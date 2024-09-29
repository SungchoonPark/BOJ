import java.util.*;
import java.time.*;

class Solution {
    static int defaultH;
    static int defaultPrice;
    static double defaultUnitTime;
    static int defaultUnitPrice;
    
    static Map<String, Integer> carPrice;
    static Map<String, Integer> cumulParkingTime;
    static List<Integer> answer;
    
    public int[] solution(int[] fees, String[] records) {
        answer = new ArrayList<>();
        carPrice = new HashMap<>();
        cumulParkingTime = new HashMap<>();
        
        defaultH = fees[0];
        defaultPrice = fees[1];
        defaultUnitTime = (double) fees[2];
        defaultUnitPrice = fees[3];
        
        Set<String> carNums = new HashSet<>();
        Map<String, LocalTime> carRecords = new HashMap<>();
        PriorityQueue<String> finalCarNums = new PriorityQueue<>();
        
        for(String s : records) {
            String[] tmp = s.split(" ");
            String time = tmp[0];
            String carNumber = tmp[1];
            String type = tmp[2];
            
            String[] times = time.split(":");
            Integer hour = Integer.parseInt(times[0]);
            Integer min = Integer.parseInt(times[1]);
            LocalTime lt = LocalTime.of(hour, min);
            
            if(carNums.contains(carNumber)) {
                // set에 차량 번호가 존재함 -> 출차하려는 상태, 이땐 lt가 출차 시간이 됨
                LocalTime inTime = carRecords.get(carNumber);
                cumulateTime(carNumber, inTime, lt);  // 시간만 축적함
                carNums.remove(carNumber);
                if(!finalCarNums.contains(carNumber)) finalCarNums.offer(carNumber);
            } else {
                // 새롭게 들어오는 차량 -> 입차하려는 상태, 이땐 lt가 입차 시간이 됨
                carNums.add(carNumber);
                carRecords.put(carNumber, lt);
            }
        }
        
        // 아직 출차 안한 차 번호들이 set에 남아있음.
        for(String cn : carNums) {
            LocalTime inTime = carRecords.get(cn);
            LocalTime outTime = LocalTime.of(23, 59);
            cumulateTime(cn, inTime, outTime);  // 시간만 축적함
            if(!finalCarNums.contains(cn)) finalCarNums.offer(cn);
        }
            
        while(!finalCarNums.isEmpty()) {
            String carNumber = finalCarNums.poll();
            Integer cTime = cumulParkingTime.get(carNumber);
            int price = calculatePrice(carNumber, cTime);
            answer.add(price);
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static void cumulateTime(String carNumber, LocalTime inTime, LocalTime outTime) {
        Duration duration = Duration.between(inTime, outTime);
        int prevCumulMinute = cumulParkingTime.getOrDefault(carNumber, 0);
        int curDiffMinute = (int) duration.toMinutes();
        int total = prevCumulMinute + curDiffMinute;
        cumulParkingTime.put(carNumber, total);
    }
    
    private static int calculatePrice(String carNumber, Integer cumulTime) {
        if(cumulTime <= defaultH) {
            // 기본 주차요금 부가되는 경우
            return defaultPrice;
        }
        
        int overTime = cumulTime - defaultH;
        int processingTime = (int) Math.ceil((double) overTime / defaultUnitTime);
        
        return processingTime * defaultUnitPrice + defaultPrice;
    }
}