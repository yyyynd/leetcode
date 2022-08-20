package leetcode.leetCode2022_08;

public class k201 {
    public static void main(String[] args) {
        System.out.println(new k201().rangeBitwiseAnd(8, 8));
    }
    public int rangeBitwiseAnd(int left, int right) {
        int index = 0;
        while (left != right && left > 0 && right > 0){
            left >>= 1;
            right >>= 1;
            index++;
        }
        //如果出现了left的最高有效位比right低，直接返回0
        if (left == 0 && right != 0)
            return 0;

        return left << index ;
    }
}
