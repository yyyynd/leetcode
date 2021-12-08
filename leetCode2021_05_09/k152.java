package leetCode2021_05_09;


public class k152 {

    /**
     * 原方法是采用了一个双层循环，每次就散[i,j]的乘积来取出最大值
     * 但注意累乘，(这里以求最大值为例)如果之前的累乘值得出的最大值乘以当前数值，
     * 反而使得总值比不乘以累乘值的当前点值小了，我们应该更新最大值为该值，
     * 那么证明之前进行的累乘并不有助于我们得出最大累乘的组合(最小值也是这样)
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            //注意数组中是存在的负数的，也就是说最大值会变成最小值
            //最小值会变成最大值，所以这里的的更换也是为了后面正确的进行比较进行的
            //
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            //累乘值和当前点值的比较取舍维持了连续性
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }
        return max;
    }
}
