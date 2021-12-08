package leetCode2021_05_09;

public class k342 {

    public static void main(String[] args) {
        if(new k342().isPowerOfFour(2))
            System.out.println("success");
        else
            System.out.println("fail");
    }
    public boolean isPowerOfFour(int n) {
        boolean result = false;
        if(n > 0){
            while (n%4 == 0)
                n = n>>2;
            //如果最后n值为1结束循环，则代表n原值为2的幂次
            if(n == 1)
                result = true;
        }
        return result;
    }
}
