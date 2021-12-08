package leetCode2021_05_09;


/**
 * 主要思路就是先利用最简单的想法，记录第一次产生降序到最后一次产生降序为止记录为需要调整的范围
 * 在这遍历期间记录下两个位点（产生不符合条件的区间点位),然后再次遍历这个区间寻找这个区间中最小和最大值
 * 用于等下的二次更新范围
 *
 * 上述遍历结束后再进行一次遍历，遍历0到firstDowngradeIndex-1和lastDowngradeIndex到nums.length-1
 * 这是因为，只要符合升序0到firstDowngradeIndex-1中的任意点值应该都是比，最大值也是同理只不过开始点位的更新只要
 * 产生一次更新就可以结束了，但结束点位的更新要一直判断到数组遍历结束
 */
public class k581 {

    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int firstDowngradeIndex = -1;
        int lastDowngradeIndex = -1;

        for (int i = 1; i < nums.length; i++){
            //维护点位
            if(nums[i] < nums[i-1]){
                if(firstDowngradeIndex == -1)
                    firstDowngradeIndex = i - 1;
                //开始点位只更新一次，但结束点位要一直更新
                lastDowngradeIndex = i;
            }
        }

        //如果这次寻找降序点位直接没有发现产生降序
        if(firstDowngradeIndex == lastDowngradeIndex)
            return 0;

        for (int i = firstDowngradeIndex; i <= lastDowngradeIndex; i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        for (int i = 0; i < firstDowngradeIndex; i++){
            if(nums[i] > min){
                firstDowngradeIndex = i;
                break;
            }
        }

        for (int i = lastDowngradeIndex+1; i < nums.length; i++){
            if(nums[i] < max)
                lastDowngradeIndex = i;
        }

        return lastDowngradeIndex-firstDowngradeIndex+1;
    }
}
