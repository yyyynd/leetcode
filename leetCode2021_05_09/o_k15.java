package leetCode2021_05_09;

public class o_k15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            if(n % 2 == 1)
                count++;
            n  = n >> 1;
        }

        return count;
    }
}
