package leetCode2021_05_09;

/**
 * 这题首先肯定是一个排列问题了，必定是要递归循环的
 * 那么就要考虑一下剪枝来减少重复计算的问题了
 *
 * 一开始比较迷茫的点就是，因为这里符合优美条件是关系到位置的，也就是说同样abc这三个数组
 * 不同的位次排列结果是不同的，但如果按照很常用的位运算来标记每种选择情况会不会导致考虑的情况不全（因为abc，cba表示的num是一个
 *
 * 所以最烦扰我的问题是这个位次问题（因为涉及到条件要求）
 *
 * 但其实并不会，仔细想想我们实现的递归，其实这种记忆选择类型的方式，每次从记忆数组取出的值
 * 其实是剩余元素符合条件的组合数量，和我们当前已选的排列顺序没什么关系，不论是选了abc还是cba，最后剩下的defg组成的结果是不会变的
 * 且我们每次递归都是传递了当前计算的位置，同时实际上剩余元素的数量也代表了已经完成选择的位次
 *
 * 剩余多少元素，并不是直接从1位开始排列的，循环判断是有位置参数的。。。
 */
public class k526 {
    Integer[] dp;
    int length;

    public int countArrangement(int n) {
        this.length = n;
        this.dp = new Integer[1<<n];
        return dfs(1,0);
    }

    private int dfs(int curIndex,int num){
        if(dp[num] != null)
            return dp[num];
        int count = 0;
        if(num == (1 << length)-1)
            return 1;

        for(int i = 0; i < length; i++){
            if((num >> i & 1) != 0)
                continue;
            if(curIndex % (i+1) == 0 || (i+1) % curIndex == 0)
                count += dfs(curIndex+1,num | 1 << i);
        }

        dp[num] = count;
        return count;
    }
}
