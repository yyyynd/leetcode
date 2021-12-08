package leetCode2021_05_09;

public class k528 {

    int[] sums;
    int length;
    public k528(int[] w) {
        length = w.length;
        sums = new int[length+1];
        for (int i = 1; i <= length; i++)
            sums[i] = sums[i-1] + w[i-1];
    }

    public int pickIndex() {
        int r_num = (int) (Math.random()*sums[length]) + 1;
        int left = 1;
        int right = length;
        while (left < right){
            int mid = left + (right-left)>>1;
            if(sums[mid] >= r_num)
                right = mid;
            else
                left = mid+1;
        }

        return left-1;
    }
}
