package leetCode2021_10;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 要注意的点就是不存在无限不循环小数，而且这里给的上限1w位已经够多了，所以不需要考虑位数不够的情况
 *
 */
public class k166 {
    public static void main(String[] args) {
        System.out.println(new k166().fractionToDecimal(22,7));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder ans = new StringBuilder();
        long n = numerator;
        long d = denominator;
        HashMap<Long,Integer> map = new HashMap<>();
        //先处理一下
        if(n % d == 0)
            return ans.append(n/d).toString();

        if(n * d < 0 ) {
            ans.append('-');
            n = Math.abs(n);
            d = Math.abs(d);
        }
        ans.append(n/d).append('.');
        n %= d;
        while (n != 0){
            map.put(n, ans.length());
            n *= 10;
            ans.append(n / d);
            n %= d;
            if(map.containsKey(n)){
                int index = map.get(n);
                return String.format("%s(%s)",ans.substring(0,index),ans.substring(index));
            }
        }

        return ans.toString();
    }
}
