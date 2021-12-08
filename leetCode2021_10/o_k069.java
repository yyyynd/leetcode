package leetCode2021_10;

public class o_k069 {
    public static void main(String[] args) {
        System.out.println(new o_k069().peakIndexInMountainArray(new int[]{3,5,3,2,0}));
    }
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length-1;
        while (l < r){
            int mid = l + ((r - l) >> 1);
            if(mid == 0 || arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1])
                l = mid+1;
            else if(mid == arr.length-1 || arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1])
                r = mid-1;
            else
                return mid;
        }
        return l;
    }
}
