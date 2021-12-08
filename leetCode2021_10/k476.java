package leetCode2021_10;

public class k476 {
    public static void main(String[] args) {
        System.out.println(new k476().findComplement(5));
    }
    public int findComplement(int num) {
        int ans = 0;
        for (int i = 0; num >> i != 0; i++)
            ans +=  ((num >> i & 1) == 1 ? 0 : 1) << i;

        return ans;
    }
}
