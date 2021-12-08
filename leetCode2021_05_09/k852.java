package leetCode2021_05_09;

public class k852 {
    public static void main(String[] args) {
        int[] arr = {0,10,5,2};
        System.out.println(new k852().peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        if(right == 2)
            return arr[1];

        while (left < right){
            int mid = left+(right-left)/2;
            //该点比右边大，证明山峰肯定在mid左侧(也可能是就是该点
            if(mid+1 <= arr.length-1 && arr[mid] > arr[mid+1])
                right = mid;
            //该点比左边大，证明山峰肯定在mid右侧(也可能是就是该点
            if(mid-1 >= 0 && arr[mid] > arr[mid-1])
                left = mid;
        }

        return left;
    }
}
