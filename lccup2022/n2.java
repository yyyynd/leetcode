package leetcode.lccup2022;

import java.util.HashSet;

public class n2 {
    public int transportationHub(int[][] path) {
        int[] inDegree = new int[1001];
        int[] outDegree = new int[1001];
        HashSet<Integer> count = new HashSet<>();

        for(int[] p : path){
            inDegree[p[1]]++;
            outDegree[p[0]]++;
            count.add(p[1]);
            count.add(p[0]);
        }

        int num = count.size();
        for (int i = 0; i < 1001; i++){
            if (inDegree[i] == num - 1 && outDegree[i] == 0)
                return i;
        }

        return -1;
    }
}
