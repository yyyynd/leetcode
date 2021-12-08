package leetCode2021_11;

public class k598 {

    public int maxCount(int m, int n, int[][] ops) {
        int ansField_w = m;
        int ansField_l = n;
        for(int[] o : ops){
            ansField_w = Math.min(ansField_w, o[0]);
            ansField_l = Math.min(ansField_l, o[1]);
        }

        return ansField_w * ansField_l;
    }
}
