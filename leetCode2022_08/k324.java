package leetcode.leetCode2022_08;

import java.util.Arrays;

/**
 * 如果数字无重复本题是相当简单的，但如果出现重复数字就比较麻烦了（指中位数值为重复数字）
 * 因此这里最基本的解法就是直接排序从中间切割，这样就可以把中间重复的一部分之前优先分配
 * 从而达到分离的目的
 *
 * 进阶的思路就是找到中位数值，直接将比他小的值放其左边，大的放右边（类似快排），然后和
 * 上面一样从中间分割进行插入
 */
public class k324 {
    public static void main(String[] args) {
        new k324().wiggleSort(new int[]{4,5,5,6});
    }
    public void wiggleSort(int[] nums) {

        int[] clone = nums.clone();
        Arrays.sort(clone);
        //两个指针
        int left = (nums.length - 1) / 2, right = nums.length - 1;
        //依次放置
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = clone[left];
                left--;
            } else {
                nums[i] = clone[right];
                right--;
            }
        }
    }
}
