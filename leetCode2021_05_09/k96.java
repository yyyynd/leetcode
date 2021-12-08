package leetCode2021_05_09;

/**
 * 如果给出的元素集合是有序的，那么例如我们任意取5个连续的元素进行排列二叉搜索树
 * 我们能出的结果个数一定是一致的，利用这一点我们就可以设置一个记忆数组，减少重复计算
 *
 * 因为这道题使我们并不需要关心排序的具体形式，只关心数量
 *
 */
public class k96 {
    int[] dp;

    public int numTrees(int n) {
        this.dp = new int[n];
        dp[0] = 1;
        return dfs(1,n);
    }

    public int dfs(int left,int right){
        if(left >= right)
            return 1;

        //如果理论上多少个数字排出来的二叉树数量是一定的
        if(dp[right-left] != 0)
            return dp[right-left];

        int leftChildCount = 0;
        int rightChildCount = 0;
        int count = 0;

        //当前范围遍历作为根节点进行递归
        for(int i = left; i <= right; i++){
            leftChildCount = dfs(left,i-1);
            rightChildCount = dfs(i+1,right);
            count += leftChildCount*rightChildCount;
        }

        dp[right-left] = count;
        return count;
    }
}
