package leetcode.leetCode2022_10;

public class k885 {
    public static void main(String[] args) {
        System.out.println(new k885().spiralMatrixIII(1 ,4 ,0,0));
    }
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows*cols][2];
        int[] dr = {1,0,-1,0};
        int[] dc = {0,-1,0,1};
        int count = 1;
        int step = 2;
        ans[0] = new int[]{rStart, cStart};
        rStart -= 1;
        cStart += 1;
        while (true){
            for (int i = 0; i < 4; i++){
                int j = 1;
                for (; j <= step; j++){
                    if (count == rows*cols)
                        return ans;
                    rStart += dr[i];
                    cStart += dc[i];
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        ans[count++] = new int[]{rStart, cStart};
                    }
                }
//                rStart += dr[i] * (step - j);
//                cStart += dc[i] * (step - j);
            }
            step += 2;
            rStart -= 1;
            cStart += 1;
        }
    }
}
