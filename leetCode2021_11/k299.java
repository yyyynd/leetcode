package leetCode2021_11;

import leetCode2021_10.k29;

import java.nio.charset.StandardCharsets;

/**
 * 数字和位置都对算一个公牛，数字对了但位置不对算母牛
 * 公牛的话只要依次比较就可以得出来了，母牛的话需要统计字符相同个数（排除掉公牛中出现过的）
 *
 * 这题要注意的就是最好组成答案的写法，String连接需要重新开内存，而StringBuilder不需要
 * 所以StringBuilder的写法效率更高一点
 */
public class k299 {
    public static void main(String[] args) {
        System.out.println(new k299().getHint("1123", "0111"));
    }

    public String getHint(String secret, String guess) {
        int[] ser_collect = new int[10];
        int[] gue_collect = new int[10];
//        char[] sec = secret.toCharArray();
//        char[] gue = guess.toCharArray();
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secret.length(); i++){
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g)
                bulls++;
            else {
                ser_collect[s]++;
                gue_collect[g]++;
            }//else
        }//for

        for (int i = 0; i <= 9; i++){
            if (ser_collect[i] > 0 && gue_collect[i] > 0)
                cows += Math.min(ser_collect[i], gue_collect[i]);
        }

//        return String.valueOf(bulls) + 'A' + cows + 'B';
        return new StringBuilder().append(bulls).append('A').append(cows).append('B').toString();
    }//getHint
}
