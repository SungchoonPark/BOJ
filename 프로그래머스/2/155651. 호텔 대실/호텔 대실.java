import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Reserve> list = new ArrayList<>();
        for(String[] time : book_time) {
            list.add(new Reserve(time[0], time[1]));
        }
        
        list.sort((r1, r2) -> {
            Time r1InTime = r1.getInTime();
            Time r2InTime = r2.getInTime();
            
            if(r1InTime.hour == r2InTime.hour) {
                return r1InTime.min - r2InTime.min;
            }
            return r1InTime.hour - r2InTime.hour;
        });
        
        PriorityQueue<Reserve> pq = new PriorityQueue<>((r1, r2) -> {
            Time r1OutTime = r1.getOutTime();
            Time r2OutTime = r2.getOutTime();
            
            if(r1OutTime.hour == r2OutTime.hour) {
                return r1OutTime.min - r2OutTime.min;
            }
            return r1OutTime.hour - r2OutTime.hour;
        });
        
        for(Reserve r : list) {
            if(!pq.isEmpty()) {
                Reserve alReserve = pq.peek();
                if(!alReserve.getOutTime().isPossible(r.getInTime())) {
                    answer++;
                    pq.offer(r);
                } else {
                    // 빈방생김
                    pq.poll();
                    pq.offer(r);
                }
            } else {
                pq.offer(r);
                answer++;
            }
        }
        
        return answer;
    }
    
    static class Reserve {
        String inTime;
        String outTime;
        
        public Reserve(String inTime, String outTime) {
            this.inTime = inTime;
            this.outTime = outTime;
        }
        
        public Time getInTime() {
            String[] times = inTime.split(":");
            int hour = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);
            return new Time(hour, min);
        }
        
        public Time getOutTime() {
            String[] times = outTime.split(":");
            int hour = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);
            return new Time(hour, min);
        }
    }
    
    static class Time {
        int hour;
        int min;
        
        public Time(int hour, int min) {
            this.hour = hour;
            this.min = min;
        }
        
        public void plusTime() {
            if(min + 10 >= 60) {
                if(this.hour == 23) this.hour = 0;
                else this.hour++;
                this.min = this.min + 10 - 60;
            } else {
                this.min += 10;
            }
        }
        
        public boolean isPossible(Time otherInTime) {
            this.plusTime();
            
            if(this.hour == otherInTime.hour)  {
                if(this.min <= otherInTime.min) {
                    return true;
                } else return false;
            }
            
            if(this.hour < otherInTime.hour) {
                return true;
            } 
            return false;
        }
    }
}