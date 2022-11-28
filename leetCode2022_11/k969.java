package leetcode.leetCode2022_11;

import java.util.LinkedList;
import java.util.List;

public class k969 {
    public static void main(String[] args) {
        System.out.println(new k969().pancakeSort(new int[]{3,2,4,1}));
    }
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new LinkedList<>();
        for (int i = arr.length - 1; i >= 2; i--){
            if (arr[i] == i + 1)
                continue;
            for (int j = 0; j < arr.length; j++){
                if (arr[j] == i + 1){
                    ans.add(j + 1);
                    ans.add(i + 1);
                    reverse(arr, 0, j);
                    reverse(arr, 0, i);
                    break;
                }
            }
        }
        if (arr[0] == 2)
            ans.add(2);

        return ans;
    }

    public void reverse(int[] arr, int s, int e){
        while (s < e){
            int tmp = arr[s];
            arr[s] = arr[e];
            arr[e] = tmp;
            s++;
            e--;
        }
    }
}
