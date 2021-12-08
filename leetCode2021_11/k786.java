package leetCode2021_11;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class k786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> deque = new PriorityQueue<>((a,b)->Double.compare(b[0]*1.0/b[1],a[0]*1.0/a[1]));
        int preIndex = 1;
        for (int i = 0; i < n; i++) {
            if(preIndex == i)
                preIndex = i + 1;
            for (int j = preIndex; j < n; j++) {
                double t = arr[i] * 1.0 / arr[j];
                if (deque.size() < k) {
                    deque.add(new int[]{arr[i], arr[j]});
                }else if(deque.peek()[0] * 1.0 / deque.peek()[1] > t){
                    deque.poll();
                    deque.add(new int[]{arr[i], arr[j]});
                    preIndex = j;
                }
            }//for
        }//for
        return deque.poll();
    }
}
