package leetcode.leetCode2022_08;

public class k74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length;
        int top = 0;
        int bottom = matrix.length - 1;
        while (top < bottom){
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][len - 1] < target)
                top = mid + 1;
            else
                bottom = mid;
        }

        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = left + (right - left)/2;
            if (matrix[top][mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return matrix[top][left] == target;
    }
}
