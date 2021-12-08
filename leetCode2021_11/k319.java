package leetCode2021_11;

import java.util.ArrayList;
import java.util.List;

public class k319 {
    public static void main(String[] args) {
        System.out.println(new k319().bulbSwitch(3));
    }

    public int bulbSwitch(int n) {
        if (n == 0)
            return 0;

        int ans = 1;
        for (int i = 2; i <= n; i++){
            Integer[] a = decPrime(i);
            int count = 1;
            for (int l = 0; l < a.length; l++ ){
                int preNum = a[l];
                int r = l + 1;
                while ( r < a.length && a[r] == preNum)
                    r++;
                count *= r - l + 1;
                l = r-1;
            }
            if ( (count - 1) % 2 == 0)
                ans++;
        }
        return ans;
    }

    //返回质因数数组
    Integer[] decPrime(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i=2; i <= n; i++){
            while(n != i){
                if(n%i != 0){
                    break;//不能整除肯定不是因数，能够整除在这里一定是质数。因为所有的2，3,5,7
                    //都被除完之后。剩下的因数只能是奇数，且是质数。
                }
                list.add(i);
                n = n/i;
            }
        }
        list.add(n);
        return list.toArray(new Integer[0]);
    }
}
