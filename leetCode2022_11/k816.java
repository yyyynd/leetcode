package leetcode.leetCode2022_11;

import javax.print.attribute.standard.Sides;
import java.util.LinkedList;
import java.util.List;

/**
 * 对于一个坐标的限制：
 * 1.整数部分前方只能有1个0
 * 2.小数位部分在最后一位的1~9后面不能全是0
 *
 * 现在需要两个坐标，应该考虑给一段字符串看能构成几种，即我们要把整个字符串分为两个部分
 * 那么久需要根据上面的限制进行分割
 *
 * 总结一下唯一的限制就是在长度大于1的时候，末尾起始不能同时为0
 *
 * 然后就是每个段内部再进行一次划分的考虑，这个时候只用考虑小数点的位置即可（除非首位为0，那么只能放在0后面了
 * 或者末尾为0只能整个加入

 */
public class k816 {
    public static void main(String[] args) {
        System.out.println(new k816().ambiguousCoordinates("(010)"));
    }
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new LinkedList<>();
        s = s.substring(1, s.length() - 1);
        char[] str = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++){
            //考虑第一段末尾不能为0的处理（长度大于1的时候，且起始为0)
            if (i != 0 && str[0] == '0' && str[i] == '0')
                continue;
           //第二段的末尾不能为0的处理(在长度大于1的时候,且起始为0)
            if (i < s.length() - 2 && str[i+1] == '0' &&str[str.length - 1] == '0')
                continue;

            List<String> first = combine(str, 0, i);
            List<String> second = combine(str, i + 1, str.length - 1);
            for (String f : first){
                for (String e : second)
                    res.add("(" + f +", " + e +")");
            }
        }
        return res;
    }

    public List<String> combine(char[] str, int s, int e){
        List<String> res = new LinkedList<>();
        //如果起始为0，直接0.xxx形式
        if (str[s] == '0'){
            if (s == e)
                res.add("0");
            else
                res.add("0." + String.valueOf(str, s + 1, e -s));
            return res;
        }
        //如果末尾为0，直接整个数字加入
        if (str[e] == '0') {
            res.add(String.valueOf(str, s, e - s + 1));
            return res;
        }

        for (int i = s; i <= e - 1; i++){
            res.add(String.valueOf(str, s, i - s + 1) + "." + String.valueOf(str, i + 1, e - i));
        }
        res.add(String.valueOf(str, s, e - s + 1));
        return res;
    }
}
