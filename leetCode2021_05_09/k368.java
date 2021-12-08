package leetCode2021_05_09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class k368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //排序是为了满足方便判断的方式，只有加入点为最后一个元素的倍数惨符合条件
        Arrays.sort(nums);
        int[] len = new int[nums.length];
        //本质虽然还是求最大长度，但要得出排列结果，所以设置一个静态链表来维护轨迹
        int[] trace = new int[nums.length];
        int prev = 0;
        int curLen = 0;

        for(int i = 0; i < nums.length; i++){
            prev = i;
            curLen = 1;
            for (int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && len[j]+1 > curLen){
                    prev = j;
                    curLen = len[j] + 1;
                }
                len[i] = curLen;
                trace[i] = j;
            }
        }

        int endIndex = -1;
        int curMaxLen = -1;
        for(int i = 0; i < nums.length; i++){
            if(curMaxLen < len[i]) {
                curMaxLen = len[i];
                endIndex = i;
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (endIndex != trace[endIndex]){
            list.addFirst(nums[endIndex]);
            endIndex = trace[endIndex];
        }

        list.addFirst(nums[endIndex]);

        return list;
    }
}
