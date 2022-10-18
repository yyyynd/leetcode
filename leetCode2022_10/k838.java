package leetcode.leetCode2022_10;

import java.util.LinkedList;

public class k838 {
    public static void main(String[] args) {
        System.out.println(new k838().pushDominoes("RL"));
    }
    public String pushDominoes(String dominoes) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] check = new int[dominoes.length()];
        char[] memo = dominoes.toCharArray();
        int round = 1;

        //init
        for (int i = 0; i < memo.length; i++){
            if (memo[i] != '.')
                list.add(i);
        }

        while (!list.isEmpty()){
            int size = list.size();
            for (int i = 0; i < size; i++){
                int index = list.pollFirst();
                if (memo[index] == 'L' && index > 0){
                    if (memo[index - 1] == 'R'){
                        if (check[index - 1] == round)
                            memo[index - 1] = '.';
                    }else if (memo[index - 1] == '.'){
                        memo[index - 1] = 'L';
                        list.add(index - 1);
                    }
                }else if (memo[index] == 'R' && index < memo.length - 1){
                    if (memo[index + 1] == '.'){
                        check[index + 1] = round;
                        memo[index + 1] = 'R';
                        list.add(index + 1);
                    }
                }
            }
            round++;
        }//while

        return String.valueOf(memo);
    }
}
