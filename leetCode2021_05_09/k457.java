package leetCode2021_05_09;

public class k457 {
    public static void main(String[] args) {
        int[] t = {-1};
        System.out.println(new k457().circularArrayLoop(t));
    }

    public boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++){
            if(nums[i] < 0 || nums[i] > 1000)
                continue;
            int curIndex = i;
            int preIndex = -1;
            //该节点数 > 0 可以继续循环,利用1000 + i来标记是第几次循环
            while (nums[curIndex] > 0){
                if(nums[curIndex] == 1001 + i && preIndex != curIndex)
                    return true;
                else if(nums[curIndex] > 1000)
                    break;
                preIndex = curIndex;
                curIndex = (curIndex + nums[curIndex]) % nums.length ;
                //被访问点全部标记1001
                nums[preIndex] = 1001 + i;
            }
        }

        for (int i = nums.length-1; i >= 0; i--){
            if(nums[i] > 0 || nums[i] < -1000)
                continue;
            int curIndex = i;
            int preIndex = -1;
            while (nums[curIndex] < 0){
                if(nums[curIndex] == -1001 - i && preIndex != curIndex)
                    return true;
                else if(nums[curIndex] < -1000)
                    break;
                preIndex = curIndex;
                curIndex = ((curIndex + nums[curIndex]) % nums.length + nums.length) % nums.length;
                nums[preIndex] = -1001 - i;
            }
        }

        return false;
    }
}
