package leetCode2021_05_09;

public class k374 {

    public static void main(String[] args) {
        System.out.println(new k374().guessNumber(10));
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = left+(right-left)/2;
            int result = guess(mid);
            if(result == 1)
                right = mid-1;
            else if(result == -1)
                left = mid+1;
            else
                return mid;
        }
        return left;
    }

    int guess(int num){
        if(num > 6)
            return 1;
        else if (num < 6)
            return -1;
        return 0;
    }
}
