package leetcode.leetCode2021_11;

import java.util.*;

public class k15 {

    List<List<Integer>> ans = new LinkedList<>();
    HashSet<String> mem = new HashSet<>();
    HashSet<String> dp = new HashSet();

    public static void main(String[] args) {
        System.out.println(new k15().threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        dfs(nums, 0, new int[3], 0);
        return this.ans;
    }

    public boolean dfs(int[] nums, int index, int[] combination, int left){
        if(index == 2){
            int[] copy = Arrays.copyOf(combination,3);
            Arrays.sort(copy);
            StringBuilder comb = new StringBuilder();
            comb.append(Arrays.toString(copy));
        }
        for(int i = left; i < nums.length; i++){
            combination[index] = nums[i];

            if(index == 2  && combination[0] + combination[1] + combination[2] == 0){
                int[] copy = Arrays.copyOf(combination,3);
                Arrays.sort(copy);
                StringBuilder comb = new StringBuilder();
                comb.append(Arrays.toString(copy));
                //判断是否已经存在该结果了
                if(!mem.contains(comb.toString())) {
                    mem.add(comb.toString());
                    List<Integer> newAns = new LinkedList<>();
                    for (int c : copy)
                        newAns.add(c);
                    ans.add(newAns);
                    return true;
                }
            }else if(index < 2)
               dfs(nums, index+1, combination, i+1);
        }//for

        return false;
    }
}
