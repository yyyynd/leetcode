package leetCode2021_09;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 注意这种k个子集合的和的值相等的题，一定含有一个条件就是可以通过所有元素的和除以k
 * 得出目标子集合的和值
 *
 * 熟练dfs+回溯的思路，感觉回溯其实就是重置状态
 *
 * 这里的选择集合其实尽量都是优先选大的元素加入到集合中，但实际上我们还是将所有的组合情况都试了一遍
 * 但是因为我们的目标是组成k组子集，只要当前未成功就结束这个组合的递归了，所以减少了不必要的计算
 *
 * 一般这种求子集的题基本都是要尝试所有组合的，所以提升性能的方法就是进行剪枝，减少不必要的计算，提前
 * 判断出来接下来的计算还有没有必要继续（即当前情况能否直接得出结果），之前一直尝试的都是存储状态+结果，
 * 而今天这题则是通过我们希望得出的目标来设置规则减少计算量（当然也是因为元素过多，比较难以记录）
 */
public class k698 {
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int target = 0;
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        //得出目标集合的和的值
        for(int n : nums)
            target += n;
        if(target % k != 0 || nums[nums.length - 1] > target/k)
            return false;
        target /= k;
        return dfs(nums,k,target,nums.length-1,0);
    }

    /**
     *
     * @param nums 元素集合
     * @param k 剩余要组成的组合数量
     * @param target 目标集合值
     * @param begin 右侧选取元素起始位置
     * @param curSum 之前选择元素的总和
     * @return
     */
    public boolean dfs(int[] nums, int k, int target,int begin,int curSum){
        if(k == 1)
            return true;
        if(curSum == target)
            //这个--k就意味着我们不需要每一次迭代就求出一个组合的结果，完全可以传递当前的累加值
            //减少循环中处理的复杂程度，直到累加值==target，再将k减1代表完成一个组合了
            return dfs(nums,--k,target,nums.length-1,0);
        for (int i = begin; i >= 0; i--){
            //判断当前数是否已经采用过了
            if(visited[i])
                continue;
            if(curSum + nums[i] > target)
                continue;
            //开始进行dfs，如果失败进行回溯进行新的dfs
            visited[i] = true;
            if(dfs(nums,k,target,i-1,curSum + nums[i]))
                return true;
            visited[i] = false;
            //防止存在重复数字，上述步骤已知当前轮次选择该数的结果进行剪枝
            while (i > 0 && nums[i] == nums[i-1])
                i--;
        }

        return false;
    }

}
