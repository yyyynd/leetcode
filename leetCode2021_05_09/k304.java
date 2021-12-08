package leetCode2021_05_09;

public class k304 {

    public static void main(String[] args) {
        int[][] arr = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        k304 s = new k304(arr);
    }

    int[][] sum;

    public k304(int[][] matrix) {
        this.sum = new int[matrix.length][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++){
            int[] arr = matrix[i];
            sum[i][1] = arr[0];
            for (int j = 2; j < matrix[0].length+1; j++)
                sum[i][j] = sum[i][j-1]+arr[j-1];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for(int i = row1; i <= row2; i++)
            result += (sum[i][col2+1]-sum[i][col1]);

        return result;
    }
}
