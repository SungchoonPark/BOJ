import java.util.*;

class Data {
    int code;
    int date;
    int maximum;
    int remain;
    
    public Data(int code, int date, int maximum, int remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }
    
    public int getTmp(String exp) {
        if(exp.equals("code")) return this.code;
        else if(exp.equals("date")) return this.date;
        else if(exp.equals("maximum")) return this.maximum;
        else return this.remain;
    }
}
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> list = new ArrayList<>();
        List<Data> satis = new ArrayList<>();
        for(int i=0; i<data.length; i++) {
            list.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
        }
        
        for(Data d : list) {
            int get = d.getTmp(ext);
            if(get < val_ext) satis.add(d);
        }
        
        Collections.sort(satis, (d1, d2) -> {
            return d1.getTmp(sort_by) - d2.getTmp(sort_by);
        });
        
        int[][] answer = new int[satis.size()][4];
        for(int i=0; i<satis.size(); i++) {
            answer[i][0] = satis.get(i).code;
            answer[i][1] = satis.get(i).date;
            answer[i][2] = satis.get(i).maximum;
            answer[i][3] = satis.get(i).remain;
        }
        return answer;
    }
}