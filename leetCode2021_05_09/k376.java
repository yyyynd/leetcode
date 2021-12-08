package leetCode2021_05_09;

/**
 * 这里为什么只做了相邻点的两两比较就做到了得出结果
 * 实际上我们很清楚，我们每次遍历一个新的元素，肯定希望是和队列的结尾
 * 进行比较，这里的比较似乎并不能确定nums[i-1]就是队尾元素，
 * 但实际上这里面隐藏了元素的替换（虽然没有实际操作）
 *
 * nums[i-1]==nums[i] 等于是新加进来的nums[i]没有带来新信息 原来我们假如利用了nums[i-1]，
 * 那么现在两个数持平，既没法上升也没法下降; 假如我们原来没有利用nums[i-1]那么同样nums[i]不会被用到 故 up[i]=up[i-1], down[i]=down[i-1]
 *
 * nums[i] > nums[i-1] 我们考虑 up[i]可能的来源方式 只会跟up[i-1]和down[i-1]有关
 *
 * 首先会不会up[i-1]之后再up了？不会 因为不可以两次重复up
 *
 * down[i-1]之后可能会跳跃道nums[i]上面 但是我们担心的一个点是 谁说down[i-1]对应子序列结尾的就是nums[i-1]?
 * 确实如此。 假设down[i-1]对应的元素叫a_k不是nums[i-1], a_k<nums[i]时候，我们同样可以让a_k跳跃到nums[i]上；假设a_k>=nums[i-1],
 * 我们可以做交换把a_k换成nums[i-1]因为这样同样满足条件=> 总之可以跳跃到nums[i]上 =>up[i]=max(up[i-1], down[i-1]+1);
 *
 * 我们考虑 down[i]可能的来源方式 只会跟up[i-1]和down[i-1]有关
 *
 * 首先会不会down[i-1]之后再down了？ 不会 因为不可以两次重复down
 *
 * up[i-1]之后可能会下降道nums[i]上面 但是我们担心的一个点是 谁说up[i-1]对应子序列结尾的就是nums[i-1]?
 * 确实如此。 假设up[i-1]对应的元素叫a_k不是nums[i-1], a_k>=nums[i]>nums[i-1]时候，我们可以让他下降到nums[i-1],
 * 这个最大值会被包括在down[i-1]里；a_k<nums[i]时候没法下降到nums[i-1] 不满足条件 =>down[i]=max(down[i-1], down[i-1]);
 *
 * nums[i] < nums[i-1] 这种情况和情况2是对称的 不做展开
 *
 * 这就是官方题解中我们只用关心相邻元素的解释
 */
public class k376 {
    public int wiggleMaxLength(int[] nums) {
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }
}
