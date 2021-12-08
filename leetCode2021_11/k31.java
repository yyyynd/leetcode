package leetCode2021_11;

/**
 * 想要换位后组成下一个字典序，那么我们肯定是希望交换位置靠右的元素（这个位肯定是越靠右越好
 * 因为越右的点对字典顺序影响越小，，且这两个元素的差值要尽量小
 * 因为这样才能获得最近的字典序字符串
 *
 * 题解的思路是首先从后往前找第一对相邻的升序点（即 N[i] < N[j]）这同时保证了[j - end] 的所有
 * 元素全部为降序的（现在我们需要的是交互一对升序点来达到产生更大字典序组合的目的），这两个节点
 * 直接交换不一定是最优解，由于[j - end]是降序的，也就意味着在这个范围内可能还有更优解，所以再一次
 * 进行查询，找出最优解，然后对交换之后的[j - end]进行一次升序排序得出最终结果
 *
 * 为用第一个相邻升序点就能找出较小的那个换节点？
 * 因为第一个相邻升序点，意味着之前的结点组成的是一个降序顺序，里面的两两结点都不符合我们希望的找出一个左侧小值
 * 和右侧大值进行交换得出新序列的目的，所以第一对相邻升序点的左侧点位就是目前我们能找到最右点了，而且第二次的搜索也保证
 * 了不会漏掉[j-end]中的更优解，其实第一次搜索相当于找出了一个大致范围
 */

public class k31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int firstIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int secondIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1, nums.length - 1);
        return;

    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }

}
