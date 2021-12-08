package leetCode2021_05_09;

public class k553 {

    public String optimalDivision(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        if(nums.length==1)
            return String.valueOf(nums[0]);
        else if(nums.length == 2){
            stringBuilder.append(nums[0]).append('/').append(nums[1]);
            return stringBuilder.toString();
        }
        stringBuilder.append(nums[0]).append("/(");
        for (int i = 1; i < nums.length-1; i++)
            stringBuilder.append(nums[i]).append("/");

        stringBuilder.append(nums[nums.length - 1]).append(")");
        return stringBuilder.toString();
    }
}
