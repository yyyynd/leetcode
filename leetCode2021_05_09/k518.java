package leetCode2021_05_09;

public class k518 {
    public static void main(String[] args) {
        int[] arr= {1,2,5};
        System.out.println(new k518().change(5,arr));
    }

    public int change(int amount, int[] coins){

        if (amount == 0)
            return 1;

        int row = coins.length;
        int[] dp = new int[amount+1];
        //面值最大且不会直接大于amount的面值下标(以0为开始
        int availableIndex = -1;
        for(int value : coins){
            if(value > amount)
                break;
            availableIndex++;
        }
        if(availableIndex != -1)
            dp[0] = 1;
        else
            return 0;

        for(int curAmount = coins[0], kind = -1; curAmount <= amount; curAmount++){
            //如果当前最大的面值和当前最大总额度相当，则意味着可以把该面值纳入考虑
            //这里注意kind从 0 开始，所有当前种类下标都以kind+1进行判断（kind+1就是判断的硬币种类
            //如果自增一了，则代表下一个硬币种类纳入考虑了
            if(kind < availableIndex && coins[kind+1] == curAmount)
                kind++;
            //进行计算
            fun(kind,dp,curAmount,coins);
        }

        return dp[amount];
    }

    /**
     *就类似爬楼梯题，一样只不过这里可以选择的“步数”是动态的
     * 并且例如112 211这种算是一种方案，因为这里我们要的是组合数而不是排列数
     * 所以通过for循环处理这个动态问题
     *
     * @param kind num of available coin
     * @param dp result matrix
     * @param amount all coins value sum
     *
     */
    private void fun(int kind,int[] dp,int amount,int[] coins){
        for(int i = 0; i <= kind; i++)
            dp[amount] += dp[amount-coins[i]];
    }

    //方案数量
//    int count = 0;
//
//    public int change(int amount, int[] coins) {
//        if (amount == 0)
//            return count;
//
//        //有几种面值的硬币
//        int kindNum = coins.length;
//        //要考虑的特殊情况就是，如果面值直接大于amount了
//        //我们就可以不考虑这些面值的选择了(不排除最小面值就比amount大了
//        for (int i = kindNum-1; i >= 0;i--){
//            //找到面值比amount的就可以开始了
//            if (coins[i] <= amount){
//                fun(coins,i,amount);
//                break;
//            }
//        }
//        return count;
//    }
//
//    //每次都是先选最大的面值
//    private void fun(int[] coins,int kind,int remainderAmount){
//        //防止只有一种面值的时候
//        if(kind == -1)
//            return;
//        //如果到选用当前面额时，剩余值已经为0了，不需要再判断了
//        if(remainderAmount == 0){
//            count++;
//            return;
//        }
//        //只剩最小面值的可用了，如果剩余额度可以被整除证明可行
//        if(kind == 0 && (remainderAmount%coins[0]) == 0) {
//            count++;
//            return;
//        }
//        //对于当前剩余额度，该面值硬币最多可以选择多少个
//        int max = remainderAmount/coins[kind];
//
//        for (int i = 0; i <= max; i++)
//            fun(coins,kind-1,remainderAmount-i*coins[kind]);
//    }
}
