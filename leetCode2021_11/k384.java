package leetCode2021_11;

import java.util.Random;

/**
 *  这里每次循环都做一次交换后都会通过 i + random.nextInt(len - i) （i在自增） 缩小选取范围
 *  从而达到选取出一个数后不再重复选择的效果
 */

public class k384 {

    private int[] nums;
    private int len;
    private Random random = new Random();

    public k384(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] shuffle_nums = nums.clone();
        for (int i = 0; i < len; i++){
            int j = i + random.nextInt(len - i);
            int tmp = shuffle_nums[j];
            shuffle_nums[j] = shuffle_nums[i];
            shuffle_nums[i] = tmp;
        }
        return shuffle_nums;
    }
}
