package leetCode2021_05_09;

import java.util.HashMap;

/**
 * 每一次迭代判断的都应该是在剩余的数中，我能否做到取一个数做到先手必赢
 */
public class k464 {

    HashMap<Integer,Boolean> map = new HashMap<>();
    int desiredTotal;
    int maxChoosableInteger;
    Boolean[] dp;

    public static void main(String[] args) {
        System.out.println(new k464().canIWin(10,40));
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.desiredTotal = desiredTotal;
        this.maxChoosableInteger = maxChoosableInteger;
        this.dp = new Boolean[1 << maxChoosableInteger];
        if(maxChoosableInteger*(maxChoosableInteger+1)/2 < desiredTotal)
            return false;
        return fun(0,0);
    }

    /**
     *
     * @param num 标志当前已选数字的变量
     * @param curTotal 已经累加的值
     * @return
     */
    public boolean fun(int num,int curTotal){
        if(dp[num] != null)
            return dp[num];

        for (int i = 0; i < maxChoosableInteger; i++){
            int select = 0;
            if(((num >> i) & 1) == 0){
                select = i+1;
                //判断选这个数能否先手必赢
                if(curTotal+select >= desiredTotal ||
                        !fun(num | (1 << i),curTotal+select)){
//                    map.put(num,true);
                    dp[num] = true;
                    return true;
                }
            }//if
        }//for

        //只有当所有情况遍历完都没有产生先手必赢，才能判断这组元素做不当前先手必赢
//        map.put(num,false);
        dp[num] = false;
        return false;
    }
}
