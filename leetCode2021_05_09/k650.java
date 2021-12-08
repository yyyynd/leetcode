package leetCode2021_05_09;

public class k650 {
    public static void main(String[] args) {
        System.out.println(new k650().minSteps(6));
    }
    public int minSteps(int n) {
        int ans = 0;

        while (n > 1){
            int sqrt = (int) Math.sqrt(n);
            int i ;
            for (i = sqrt; i > 1; i--){
                if(n%i == 0)
                    break;
            }
            ans += n/i;
            n = i;
        }

        return ans;
    }
}
