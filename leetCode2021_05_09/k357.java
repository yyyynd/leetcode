package leetCode2021_05_09;

public class k357 {
    public static void main(String[] args) {
        System.out.println(new k357().countNumbersWithUniqueDigits(4));
    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;

        if(n == 1)
            return 10;

        int count = 9;
        for (int i = 2; i < n; i++)
            count = count*(i+1)*9+count*i;

        return (int) Math.pow(10,n) - count;
    }
}
