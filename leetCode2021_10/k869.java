package leetCode2021_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 这题开始写错是因为想要使用剪枝来减少排列的计算，但所使用的方法是记录当前已选的数字组合
 * 而这里明显是一个排列问题，也就是意味着15和51组成的是不同的数字，而我这里只是记录组合
 * 所以不行，会漏计算情况，所以要注意这种方法只能在不用在意选取顺序的情况下才能使用
 *
 * 这里换了一种思路就是，如果这个数能重新排列为2的幂数，那么它和2的幂数一定有着数量数值都相同的
 * 一组数值元素，而我们很容易计算出范围内2的幂，因此只要枚举所有2的幂得出其元素，并且与输入值进行比较
 */
public class k869 {
//    HashSet<Integer> dp = new HashSet<>();
//    int len;
//    int allPicked;

    public static void main(String[] args) {
        System.out.println(new k869().reorderedPowerOf2(521));
    }

    public boolean reorderedPowerOf2(int n) {
        //先把数字转化为字符
        char[] numChar = String.valueOf(n).toCharArray();
        //对字符进行排序（这个排序就是为了方便比较）
        Arrays.sort(numChar);
        for (int i = 0; i < 31; i++) {
            //把2的幂转化为字符，然后排序
            char[] bitChar = String.valueOf(1 << i).toCharArray();
            Arrays.sort(bitChar);
            //比较这两个数组
            if (Arrays.equals(numChar, bitChar))
                return true;
        }
        return false;
    }

//    public boolean dfs(int curNum, int picked, Integer[] nums){
//        if(dp.contains(picked))
//            return false;
//
//        if((picked ^ allPicked) == 0){
//            return (curNum & curNum - 1) == 0;
//        }
//
//        for(int i = 0; i < len; i++){
//            if((picked & 1 << i) == 0){
//                if(dfs( curNum * 10 + nums[i], picked | 1 << i, nums))
//                    return true;
//            }//if
//        }
//        dp.add(picked);
//        return false;
//    }
}
