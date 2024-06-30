class Solution {
    public int solution(int price) {
        double result = 0;
        if(price < 300000 && price >= 100000) {
            result = price * 0.95;
        } else if (price < 500000 && price >= 300000) {
            result = price * 0.9;
        } else if (price >= 500000){
            result = price * 0.8;
        } else {
            result= price;
        }
        return (int) (result * 10) / 10;
    }
}