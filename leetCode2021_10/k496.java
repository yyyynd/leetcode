package leetCode2021_10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * 这一题注意有一个性质，就是我们在搜索的时候只要右边第一个比它大的元素即可
 */
public class k496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Deque<Integer> deque = new ArrayDeque<>();
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i = nums2.length - 1; i >= 0; i--){
//            int curNum = nums2[i];
//            while (!deque.isEmpty() && deque.peekLast() < curNum)
//                deque.pollLast();
//            map.put(curNum, deque.isEmpty() ? -1 : deque.peekLast());
//            deque.addLast(curNum);
//        }
//        for (int i = 0; i < nums1.length; i++)
//            nums1[i] = map.get(nums1[i]);
//
//        return nums1;

        //记录起始点下标，减少遍历次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++)
            map.put(nums2[i], i);

        for(int i = 0; i < nums1.length; i++){
            int j = map.get(nums1[i]) + 1;
            for (; j < nums2.length; j++){
                if(nums2[j] > nums1[i]) {
                    nums1[i] = nums2[j];
                    break;
                }//if
            }//for
            if(j == nums2.length)
                nums1[i] = -1;
        }//for
        return nums1;
    }
}
