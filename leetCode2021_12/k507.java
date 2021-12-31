package leetCode2021_12;

public class k507 {
    public boolean checkPerfectNumber(int num) {
        if(num == 1)
            return false;
        int sum = 1;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                sum += i;
                sum += num / i;
            }
        }

        return sum == num;
    }
}
