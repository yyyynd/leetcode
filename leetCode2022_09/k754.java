package leetcode.leetCode2022_09;

/**
 * 最终的步数一定是小于目标值的，因此利用贪心的原理一直累加快速接近
 * 然后多余的部分删除之前累加中的一个值就行，因为本质上左右移动就相当于
 * 全是+号的多项式中把几个改为-号，但要注意的是因为之前一直是累加，此时
 * 如果改为减去，对于我们的累加值其实是减去2倍该值，因此一定要多余的值
 * 为偶数时才停止累加
 *
 * 核心思想就是如果移动绝对值累加 即 +1+2+3+...+k 一定是 >= target的
 */

public class k754 {
    public static void main(String[] args) {
        System.out.println(new k754().reachNumber(9));
    }
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 1;
        int curSum = 0;
        while (curSum < target || (curSum - target) % 2 != 0){
            curSum += step;
            step++;
        }
        step--;
        return step;

    }
}
