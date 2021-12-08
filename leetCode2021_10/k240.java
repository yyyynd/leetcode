package leetCode2021_10;

public class k240 {
    public static void main(String[] args) {
        System.out.println(new k240().searchMatrix(new int[][]{{-1,3}} , 3));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        //对每行/列进行二分查找
//        for (int[] nums : matrix) {
//            if(nums[0] > target)
//                return false;
//
//            int l = 0, r = matrix[0].length - 1;
//            while (l < r) {
//                int mid = l + (r - l) / 2;
//                if (nums[mid] >= target)
//                    r = mid;
//                else
//                    l = mid + 1;
//            }
//            if (nums[l] == target)
//                return true;
//        }
//
//        return false;
        //从右上角为根，把整个矩阵看作二叉搜索树,向左看作左子树，向下看作右子树
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0){
            if(matrix[i][j] > target)
                j--;
            else if(matrix[i][j] < target)
                i++;
            else
                return true;
        }
        return false;
    }
}
