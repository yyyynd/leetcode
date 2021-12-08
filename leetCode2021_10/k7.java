package leetCode2021_10;

public class k7 {
    public static void main(String[] args) {
        System.out.println(new k7().reverse(-123));
    }
    public int reverse(int x) {
        long ans = 0;
        if(x == 0)
            return 0;
        while ( x % 10 == 0)
            x /= 10;
        while ( x != 0){
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        if(ans > 0)
            return ans > Integer.MAX_VALUE ? 0 : (int)ans;
        else
            return ans < Integer.MIN_VALUE ? 0 : (int)ans;
    }
}
