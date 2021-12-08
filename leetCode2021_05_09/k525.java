package leetCode2021_05_09;

import java.util.HashMap;

public class k525 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,0,0,0,1,1};
        System.out.println(new k525().findMaxLength(nums));
    }

    /**
     * 和k532差不多，都是找符合条件的最大长度子串
     * 因为都涉及到子串所有元素相加的性质，所以利用前缀和不但可以减少重复计算
     * 同时通过b-a是可以得出任意子串的
     *
     * 主要的问题就是如何得出最长子串，单纯的双重遍历肯定不行，那样时间复杂度就是O(n²)了
     * 这里两题都是利用一定的性质和b-a可以得出任意子串的性质，每次都记录之前子串
     * 比如k532是记录了区间总和计算后的余数，这里记录了区间总和值
     *
     * 为什么只记录一次特性值呢，因为这里要求最大的长度子串，肯定是希望之前记录的左端点下标越小
     * 越好，且这里两道题得出符合条件区间的方式，都是利用两个有相同特性值的子串得出的，也就说
     * 反正是为了找两个相同特性子串，第一个找到的不如越靠前越好（这样就避免了考虑那些无用的可能性）
     *
     * 这样理解，就算一个串中有数个特征为m的子串，对我们来说，我们需要算出第i-3,i-2个这种的子串的关系吗？
     * 并不需要，因为我们只要求最长的，所以我们只要关注第1个和第i个就行了
     *
     * 这里讲0值算为-1，是因为得出的子串一定是一半0一半1的偶数子串，所以这样转换
     * 就可以看作要得出的子串区间相加为0，这样b-a=0就意味着为符合条件子串，同时
     * 也避免了0无法体现在累加中的问题（如[0,0,0,0]）这样提醒我们如果需要判断0时
     * 可以把0转换为一个有实际意义的值
     */
    public int findMaxLength(int[] nums) {
        int row = nums.length;
        if(row <= 1)
            return 0;
        int[] sum = new int[row+1];
        for(int i = 1; i <= row; i++)
            sum[i] = sum[i-1] + (nums[i-1] == 0 ? -1 : 1);

        int maxLength = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 2; i <= row; i += 1){
            if(!map.containsKey(sum[i-2]))
                map.put(sum[i-2],i-2);
            if(map.containsKey(sum[i]))
                maxLength = Math.max(maxLength,i-map.get(sum[i]));
        }

        return maxLength;
    }
}
