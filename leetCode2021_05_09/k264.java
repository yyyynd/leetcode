package leetCode2021_05_09;

import java.util.HashSet;
import java.util.PriorityQueue;

public class k264 {

    public static void main(String[] args) {
        System.out.println(new k264().nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        HashSet<Long> numberSet = new HashSet<>();
        PriorityQueue<Long> numberQueue = new PriorityQueue<>();
        int[] primeFactors = {2,3,5};
        numberSet.add(1L);
        numberQueue.add(1L);

        for(int i = 1; i <= n;i++){
            long curNum = numberQueue.poll();
            if(i == n)
                return (int)curNum;
            for(int j = 0; j <= 2; j++){
                if(numberSet.add(curNum*primeFactors[j]))
                    numberQueue.add(curNum*primeFactors[j]);
            }//for(int j
        }//for(int i

        return -1;
    }
}
