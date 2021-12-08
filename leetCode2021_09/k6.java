package leetCode2021_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 这道题的最优解是找出数学规律（每次遍历计算出新组成字符串的下标
 *
 * 下面这个的思路值得学习的就是利用flag的变化实现来回遍历
 * 因为我们知道按照走Z字型其实就是把字符按照顺序每次放置在不同的行上
 * 这就设计到行数的变化，这里就是利用flag反转实现向前向后的逻辑
 */
public class k6 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] s =  new char[5];
        s[0] = 'a';
        s[4] = 'a';
        stringBuilder.append(s);
        System.out.println(stringBuilder.toString());
    }

    public String convert(String s, int numRows) {
        if(numRows <= 1)
            return s;

        StringBuilder ans = new StringBuilder();
        StringBuilder[] row = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            row[i] = new StringBuilder();

        char[] str = s.toCharArray();
        int flag = -1;
        int count = 0;
        for(char c : str){
            row[count].append(c);
            if(count == 0 || count == numRows-1)
                flag = -flag;
            count += flag;
        }

        for (StringBuilder sb : row)
            ans.append(sb);
        return ans.toString();
    }
}
