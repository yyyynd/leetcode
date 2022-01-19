package leetCode2022_01;

import java.util.*;

public class k219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= k && i < nums.length; i++){
            if(!set.add(nums[i]))
                return true;
        }

        for (int i = k + 1; i < nums.length; i++){
            int head = nums[i - k - 1];
            set.remove(head);
            if(!set.add(nums[i]))
                return true;
        }
        return false;
//        HashMap<Integer,Integer> map = new HashMap<>();
//        Deque<Integer> deque = new LinkedList<>();
//        for (int i = 0; i <= k && i < nums.length; i++) {
//            if(map.containsKey(nums[i]))
//                return true;
//            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
//            deque.add(nums[i]);
//        }
//
//        for (int i = k + 1; i < nums.length; i++){
//            int first = deque.poll();
//            int first_count = map.get(first);
//            //去掉窗口第一个元素
//            if(first_count == 1)
//                map.remove(first);
//            else
//                map.put(first, first_count - 1);
//
//            if(map.containsKey(nums[i]))
//                return true;
//            map.put(nums[i], 1);
//            deque.add(nums[i]);
//        }


    }
}
