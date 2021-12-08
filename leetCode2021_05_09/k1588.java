package leetCode2021_05_09;

public class k1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] sum = new int[arr.length];
        int ans = 0;
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
            ans += arr[i];
        }

        for(int i = 3; i <= arr.length; i += 2){
            ans += sum[i-1];
            for (int j = 0; j+i < arr.length; j++)
                ans += sum[j+i] - sum[j];
        }

        return ans;
    }
}
