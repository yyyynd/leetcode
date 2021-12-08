package leetCode2021_05_09;

import java.util.Arrays;

public class k881 {
    public static void main(String[] args) {
        System.out.println(new k881().numRescueBoats(new int[]{2,2,2,3},1));
    }

    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        int r = people.length-1;
        int l = 0;
        Arrays.sort(people);
        while (l < r){
            int mid = l + (r-l)/2 +1;
            if(people[mid] <= limit)
                l = mid;
            else
                r = mid-1;
        }

        if(people[l] == limit)
            r--;
        ans += people.length - r -1;
        l = 0;

        while (l < r){
            if(people[l] + people[r] <= limit){
                ans++;
                l++;
                r--;
            }else{
                ans++;
                r--;
            }
        }//while

        if(l == r)
            ans++;

        return ans;
    }
}
