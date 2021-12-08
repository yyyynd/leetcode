package leetCode2021_09;

/**
 * 一种思路就是用正数表示出负数的补码（也就是说符号位也看做值位
 * 另一种就是利用本身就是补码表示，通过位运算得出每4位一组的数值（这个过程也把符合位看做值位了）
 */
public class k405 {
    public static void main(String[] args) {
        long num = (long)Math.pow(2,32);
        long num12 = num + (-1);
        System.out.println(num);
    }
    public String toHex(int num) {
        if (num == 0) return "0";
        long n = num;
        StringBuilder ans = new StringBuilder();
        if(n < 0) n = (long)(Math.pow(2, 32) + n);
        while (n != 0) {
            long u = n % 16;
            char c = (char)(u + '0');
            if (u >= 10) c = (char)(u - 10 + 'a');
            ans.append(c);
            n /= 16;
        }
        return ans.reverse().toString();

    }
}
