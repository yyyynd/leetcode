package leetCode2021_11;

public class k400 {
    public static void main(String[] args) {
        System.out.println(new k400().findNthDigit(1000000000));
    }
    public int findNthDigit(int n) {
        if(n <= 9)
            return n;

        int a = 1,b = 1;
        long tmp = 9;
        while (n > tmp){
            a *= 10;
            b++;
            tmp += (long) a * b * 9;
        }

        for (int i = 1, j = 1; i < b; i++ , j *= 10){
            n -= i * j * 9;
        }

        int d = n % b == 0 ? b : n % b;
        tmp = a + (n % b == 0 ? n / b - 1 : n / b);
        for (int i = b; i > d; i--){
            tmp /= 10;
        }
        return (int)(tmp % 10);
    }
}
