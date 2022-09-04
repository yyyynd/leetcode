package leetcode.leetCode2022_09;

public class k498 {
    public static void main(String[] args) {
        new k498().findDiagonalOrder(new int[][]{{1,2,3,4}});
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int[] ans = new int[mat.length * mat[0].length];
        int row = 0, col = 0;
        int[] direction = {-1, 1};
        int rowLimit = mat.length;
        int colLimit = mat[0].length;
        for (int i = 0; i < rowLimit * colLimit; i++){
            if (row < 0 || col < 0 || row == rowLimit || col == colLimit){
                if (direction[0] == 1){
                    col += 1;
                    if (row == rowLimit) {
                        col += 1;
                        row -= 1;
                    }
                    direction[0] = -1;
                    direction[1] = 1;
                }else {
                    row += 1;
                    if (col == colLimit) {
                        col -= 1;
                        row += 1;
                    }
                    direction[0] = 1;
                    direction[1] = -1;
                }
            }
            ans[i] = mat[row][col];
            row += direction[0];
            col += direction[1];
        }

        return ans;
    }
}
