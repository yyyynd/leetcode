package leetcode.leetCode2022_07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class k658 {
    public static void main(String[] args) {
        System.out.println(new k658().findClosestElements(new int[]{1,1,1,10}, 1, 9));
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> ans = new LinkedList<>();
        int[] tmp = new int[k];
        int head = 0;
        int headValue = Math.abs(arr[0] - x);
        for (int i = 0; i < k; i++)
            tmp[i] = arr[i];

        for (int i = k; i < arr.length; i++){
            int newValue = Math.abs(arr[i] - x);
            if(newValue <= headValue){
                if (newValue == headValue && arr[i] > tmp[head])
                    break;
                tmp[head] = arr[i];
                head = (head + 1) % k;
                headValue = Math.abs(tmp[head] - x);
            } else
                break;
        }

        for (int i = 0; i < k; i++){
            ans.add(tmp[head]);
            head = (head + 1) % k;
        }
        return ans;
    }
}
