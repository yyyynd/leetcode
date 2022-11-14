package leetcode.leetCode2022_11;

/**
 * 通过观察发现，最后既然只剩余一个元素，那么考虑到间隔删除以及
 * 左右方向变化的特性，其实只要考虑整个队列的头元素的变化即可
 * （毕竟剩到最后一个其实本身也是队列头节点
 */
public class k390 {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;
        while (n > 1) {
            //从左边开始移除 or（从右边开始移除，数列总数为奇数）
            if (left || n % 2 != 0) {
                head += step;
            }
            step *= 2; //步长 * 2
            left = !left; //取反移除方向
            n /= 2; //总数 / 2
        }

        return head;
    }
}
