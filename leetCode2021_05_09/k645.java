package leetCode2021_05_09;

import java.util.Arrays;

/**
 * 注意这题的元素顺序是无序的！！！！！！！
 */
public class k645 {

    public static void main(String[] args) {
        int[] t = {3,2,3};
        System.out.println(Arrays.toString(new k645().findErrorNums(t)));
    }

    public int[] findErrorNums(int[] nums) {

        int errIndex = 1;
        // 1表示升序，-1表示降序
        int flag = 0;
        //因为开始靠01位置的两个数设置升降序判断，但如果上来
        //两个数就相同或者直接差值大于1了，肯定直接得出错误结果的位数了
        if(nums[1] - nums[0] == 0 || Math.abs(nums[1] - nums[0]) > 1){
            if(nums[0] == 1)
                return new int[]{nums[1],2};
            else
                return new int[]{nums[1],nums[0]-1};
        }

        flag = nums[1] - nums[0] > 0? 1 : -1;

        int d_value = 0;
        for(int i = 1; i < nums.length-1; i++){
            d_value = nums[i+1]-nums[i];
            if(d_value != flag){
                errIndex = i+1;
                break;
            }
        }
        if(flag == 1) {
            //这个额外处理主要也是解决开头的问题(总长度仅为3时）
            if(d_value < 0 && errIndex == nums.length-1)
                return new int[]{nums[errIndex], 1};
            return new int[]{nums[errIndex], nums[errIndex - 1] + 1};
        }
        else {
            if(d_value > 0 && errIndex == nums.length-1)
                return new int[]{nums[errIndex], 1};
            return new int[]{nums[errIndex], nums[errIndex - 1] - 1};
        }
    }
}
