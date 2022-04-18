package leetcode.leetCode2022_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class k46 {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> combine = new LinkedList<>();
    int len;
    public List<List<Integer>> permute(int[] nums) {
        this.len = nums.length;
        dfs(0, nums);
        return ans;
    }

    public void dfs(int memo, int[] nums){
        if (combine.size() == this.len) {
            ans.add(new LinkedList<>(combine));
            return;
        }

        for (int i = 0; i < this.len; i++){
            if ( (memo >> i & 1) != 1){
                combine.add(nums[i]);
                dfs(memo | 1 << i, nums);
                combine.removeLast();
            }
        }
    }
}
