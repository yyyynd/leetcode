package leetcode.leetCode2022_04;

import java.util.PriorityQueue;

public class k215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();//系统默认即为小根堆
        int i = 0;
        for(;i < k;i++)
            queue.add(nums[i]);//前k个元素建堆，也可以用offer
        for(;i < nums.length;i++)
            if(queue.peek()<nums[i]){//peek拿出堆顶元素比大小
                queue.poll();
                queue.add(nums[i]);//java中没有replace操作，拆分成两步
            }
        return queue.peek();

    }
}
