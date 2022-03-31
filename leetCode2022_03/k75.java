package leetcode.leetCode2022_03;

/**
 * 一开始还想着是只要两端做成0和2，中间的填1就行了
 * 但实际上我在做遍历的时候，travel左侧应该一直是0...01...1
 * 如果travel访问到了新的0，只要把left位置上的第一个1交换就能继续
 * 维持0...01...1的格式了
 */
public class k75 {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int travel = 0;
        while (travel <= right){
            if( nums[travel] == 0 ){
                nums[travel] = nums[left];
                nums[left] = 0;
                travel++;
                left++;
            }else if ( nums[travel] == 2 ){
                nums[travel] = nums[right];
                nums[right] = 2;
                right--;
            }else
                travel++;
        }

//        while ( left <= right ){
//            nums[left] = 1;
//            left++;
//        }
    }
}
