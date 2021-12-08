package leetCode2021_05_09;

public class k231 {
    public static void main(String[] args) {
        System.out.println(-32>>1);
    }

    public boolean isPowerOfTwo(int n) {
        boolean result = false;
        if(n > 0){
            while (n%2 != 1)
                n = n>>1;
            //如果最后n值为1结束循环，则代表n原值为2的幂次
            if(n == 1)
                result = true;
        }
        return result;
    }
}
