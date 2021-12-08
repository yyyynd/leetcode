package leetCode2021_05_09;

/**
 *不管正推反推都是肯定以二倍为操作才能快速迫近目标
 *
 * 按照提议增只能乘2倍，降只能减1，那么如果当前数x大于目标y很简单一直递减就行了
 * 如果x小于y则比较麻烦了，我们肯定希望多执行乘二操作快速迫近目标值，但做乘法迫近
 * 其实很难设计，因为很难考虑何时通过减1操作的执行时机（你不减1只乘2很容易超过目标很多，最后靠减一明显不合理）
 *
 * 这时就反思路，如果改用从y迫近x呢（从大到小），改为用除2和加1，
 */
public class k991 {
    public static void main(String[] args) {
        System.out.println(new k991().brokenCalc(1 ,1000000000));
    }
    public int brokenCalc(int X, int Y) {
        if (Y <= X)
            return X - Y;
        int cnt1 = 0;
        while (X < Y) {
            X *= 2;
            cnt1 ++;
        }
        if (X == Y)
            return cnt1;
        int r = X - Y;
        int cnt2 = 0;
        for (int i = cnt1; i >= 0; i --) {
            int t = (int)Math.pow(2, i);
            int coeff = r / t;
            r = r % t;
            cnt2 += coeff;
            if (r == 0)
                break;
        }
        return cnt1 + cnt2;
    }

}