package leetCode2021_05_09;

/**
 * 注意，这个边界意味着该区间内的所有备选起跳点无论怎么跳（只跳1,2...n-1,n）
 * 所能达到的最远距离也就是这个边界
 */
public class k55 {


    public boolean canJump(int[] nums) {
        boolean result = false;
        int maxIndex = 0;
        int border = 0;
        for(int i = 0; i < nums.length-1; i++){
            maxIndex = Math.max(maxIndex,i+nums[i]);
            if(maxIndex >= nums.length-1){
                result = true;
                break;
            }
            //注意这个判断是考察过所有下次可作为备选起跳点后才会进入的分支
            if(border == i) {
                //假设当前区间中的所有点可到达的距离只能是区间最右端点（意味着最右端点值为0）
                if(border == maxIndex)
                    break;
                if(nums[maxIndex] == 0)
                    break;
                //设置下一区间的右半边
                border = maxIndex;
            }
        }//for

        return result;
    }
}
