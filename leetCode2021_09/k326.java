package leetCode2021_09;

/**
 * 这种求幂的题，其实完全可以利用第n个幂数一定是第n-1个幂数的 i 倍来进行计算
 */
public class k326 {
    public boolean isPowerOfThree(int n) {
        if(n == 0 )
            return false;

        while (n > 1){
            if(n % 3 != 0)
                return false;
            n = n/3;
        }

        return true;
    }
}
