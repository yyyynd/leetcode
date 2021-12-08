package leetCode2021_10;

import java.util.HashSet;

/**
 * 好数的定义是翻转后是有效数字，同时还必须和原本的数字不同
 * 那么理论上只要产生新变化的位数是一个可以翻转成可行数字的数+剩余位是一个好数or
 * 首位是一个好数+一个翻转后仍为可行数的数
 */
public class k788 {

    public int rotatedDigits(int n) {
        HashSet<Integer> dp = new HashSet<>();
        int index = 0;
        int ans = 0;
        dp.add(2);
        dp.add(5);
        dp.add(6);
        dp.add(9);
        dp.add(0);
        for(int i = 1; i <= n; i++){
            if(i == Math.pow(10,index+1))
                index++;

            int a = i % (int)Math.pow(10, index);
            int b = (i - a) / (int)Math.pow(10, index);
            if(dp.contains(a) && dp.contains(b)){
                ans++;
                dp.add(i);
            }
        }

        return ans;
    }
}
