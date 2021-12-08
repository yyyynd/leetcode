package leetCode2021_05_09;

public class m08_01 {


    public static void main(String[] args) {
        System.out.println(new m08_01().waysToStep(61));
    }

    public int waysToStep(int n) {
        int[] step = new int[n];
        if(1<=n)
            step[0] = 1;
        if(2<=n)
            step[1] = 2;
        if(3<=n)
            step[2] = 4;

        for(int i = 3; i < n; i++) {
            step[i] = (step[i - 1] + step[i - 2]) % 1000000007 + step[i - 3];
            step[i] %= step[i];
        }
        return step[n-1];
    }
}
