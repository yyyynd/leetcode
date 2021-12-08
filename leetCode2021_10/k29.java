package leetCode2021_10;

public class k29 {
    public static void main(String[] args) {
        System.out.println(new k29().divide(-231,
                3));
    }
    public int divide(int dividend, int divisor) {
        long remainder = 0;
        long ans = 0;
        int index = 0;
        int flag = 1;
        long dividend_l = dividend;
        long divisor_l = divisor;

        if((dividend < 0 && divisor > 0 ) || (dividend > 0 && divisor < 0 ))
            flag = -1;
        if(dividend_l < 0)
            dividend_l *= -1;
        if(divisor_l < 0)
            divisor_l *= -1;

        //溢出的运算
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        //统计dividend位数
        while (dividend_l >> index != 0)
            index++;
        index--;

        while (index >= 0){
            remainder = (remainder << 1) + (dividend_l >> index & 1);
            if(remainder >= divisor_l){
                remainder = (remainder - divisor_l);
                ans = (ans << 1) + 1;
            }else
                ans <<= 1;

            index--;
        }
        ans *= flag;
        return ans >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)ans;
    }
}
