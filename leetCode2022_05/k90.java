package leetcode.leetCode2022_05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 这题需要预先排序一次，是因为我希望靠在同一层次去掉重复点来保证最终
 * 没有重复子集，就比如这里的44414，在第一层次遍历的时候，访问过4，于是一直
 * 跳过直到1，但到1进入下一层次的时候后面又有4，产生41 14这样的重复
 * 所以需要排序，实现彻底的跳过
 */
public class k90 {
    public static void main(String[] args) {
        new k90().subsetsWithDup(new int[]{4,4,4,1,4});
    }
    List<List<Integer>> ans = new LinkedList<>();
    int len;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        //空集
        ans.add(new LinkedList<>());
        this.len = nums.length;
        dfs(nums, 0, new LinkedList<>());

        return ans;
    }

    public void dfs(int[] nums, int left, LinkedList<Integer> sub){
        //每一个层次进行记录，不能出现重复数字
        HashSet<Integer> memo = new HashSet<>();
        for (int i = left; i < this.len; i++){
            if (memo.contains(nums[i]))
                continue;
            memo.add(nums[i]);
            sub.add(nums[i]);
            ans.add(new LinkedList<>(sub));
            dfs(nums, i+1, sub);
            sub.removeLast();
        }
    }
}
