package leetCode2021_11;

public class k367 {
    public static void main(String[] args) {
        System.out.println(new k367().isPerfectSquare(16));
    }
    public boolean isPerfectSquare(int num) {
//        int x = 1;
//        while (num > 0) {
//            num -= x;
//            x += 2;
//        }
//        return num == 0;

        long l = 1, r = num;
        while (l < r){
            long mid = l + (r - l)/2;
            if(mid * mid >= num)
                r = mid ;
            else
                l = mid + 1;
        }

        return l * l == num;
    }
}
