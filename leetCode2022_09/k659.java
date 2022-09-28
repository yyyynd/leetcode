package leetcode.leetCode2022_09;

import java.util.LinkedList;

public class k659 {

    public static void main(String[] args) {
        System.out.println(new k659().isPossible(new int[]{1,2,3,5,5,6,7}));
    }
    public boolean isPossible(int[] nums) {
        if (nums.length < 3)
            return false;
        int pre = 0;
        int len1 = 0;
        int len2 = 0;
        int len3 = 0;
        for (int i = 0; i < nums.length; i++){
            int count = 1; //数量统计
            while ( i < nums.length - 1 && nums[i + 1] == nums[i]){
                i++;
                count++;
            }
            if (pre + 1 != nums[i]){//如果新数字不连续，直接去除所有序列
                if (len1 != 0 || len2 != 0)
                    return false;
                len3 = 0;   //清空
            }
            //进行拼接
            if (len1 + len2 > count)    //首先检查是否能够满足长度1和2的拼接
                return false;
            else {  //考虑是否除去长度3的序列和新增长度1的序列
                if (len1 + len2 + len3 > count){
                    len3 = count - (len1 + len2);
                    len3 += len2;
                    len2 = len1;
                    len1 = 0;
                }else {
                    int tmp = count - (len1 + len2 + len3); //新增1的数量
                    len3 += len2;
                    len2 = len1;
                    len1 = tmp;
                }
            }
            pre = nums[i];
        }
        //最后检查剩余未清除的序列
        return len1 == 0 && len2 == 0;
    }
}
