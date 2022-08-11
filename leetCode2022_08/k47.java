package leetcode.leetCode2022_08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class k47 {
    public static void main(String[] args) {
        System.out.println(new k47().permuteUnique(new int[]{1,2,3,4}));
    }

    HashMap<Integer, List<List<Integer>>> memo = new HashMap<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        return dfs(0, nums);
    }

    public List<List<Integer>> dfs(int taboo, int[] nums){
        if (memo.containsKey(taboo))
            return memo.get(taboo);

        List<List<Integer>> subAns = new LinkedList<>();
        //防止重复
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if ((taboo >> i & 1) == 0 && !set.contains(nums[i])){
                set.add(nums[i]);
                List<List<Integer>> sub = dfs(taboo | 1 << i, nums);
                if (sub.size() == 0) {
                    LinkedList<Integer> s = new LinkedList<>();
                    s.add(nums[i]);
                    subAns.add(s);
                }else {
                    for (List<Integer> l : sub) {
                        LinkedList<Integer> s = new LinkedList<>(l);
                        s.addFirst(nums[i]);
                        subAns.add(s);
                    }
                }
            }
        }//for
        memo.put(taboo, subAns);
        return subAns;
    }
}
