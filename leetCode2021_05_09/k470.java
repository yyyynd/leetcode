package leetCode2021_05_09;

public class k470 {
    public int rand10() {
        int ans;
        while (true){
            ans = (rand7() - 1)*7 + (rand7() - 1);
            if(ans > 0 && ans < 41)
                return ans%10 + 1;
        }
    }

    public int rand7() {
        return 0;
    }
}
