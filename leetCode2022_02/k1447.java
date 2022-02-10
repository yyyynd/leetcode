package leetcode.leetCode2022_02;

import java.util.LinkedList;
import java.util.List;

public class k1447 {
    public List<String> simplifiedFractions(int n) {
        LinkedList<String> list = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                if(existDivisor(i,j))
                    continue;
                list.add(stringBuilder.append(j).append('/').append(i).toString());
                stringBuilder.delete(0,stringBuilder.length());
            }
        }

        return list;
    }

    public boolean existDivisor(int a, int b){
        if(a == b)
            return true;

        while (a != b){
            if(a > b)
                a = a - b;
            else {
                b = b - a;
            }
        }

        return a != 1;
    }
}
