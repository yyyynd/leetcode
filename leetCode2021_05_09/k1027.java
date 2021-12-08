package leetCode2021_05_09;

import java.util.*;

public class k1027 {
    public static void main(String[] args) {
        int[] nums = {9,4,7,2,10};
        System.out.println(new k1027().longestArithSeqLength(nums));
    }
    public int longestArithSeqLength(int[] nums) {
        int row = nums.length;
        //用一个表存储，差值

        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();

        for(int i = 0; i <= row-2; i++){
            for (int j = i+1; j <= row-1; j++){
                int diff = Math.abs(nums[i]-nums[j]);
                if(diff == 0)
                    continue;
                if(!map.containsKey(diff)) {
                    map.put(diff, new HashSet<>());
                    map.get(diff).add(nums[i]);
                    map.get(diff).add(nums[j]);
                    continue;
                }
                map.get(diff).add(nums[j]);
            }
        }

        Collection<HashSet<Integer>> collection = map.values();
        collection.stream().sorted((HashSet<Integer> integers, HashSet<Integer> t1) -> {
            if(integers.size() > t1.size())
                return -1;
            else if (integers.size() < t1.size())
                return 1;
            return 0;
        });

        return collection.iterator().next().size();
    }
}
