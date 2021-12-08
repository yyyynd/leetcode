package leetCode2021_10;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 数字转字符串，那么就要考虑到英文中数字的表达了
 * 英文中区分为个位数（1-9）,十位（10-19）和（ i * 10)的表示，随后就是百位（100）,千位(1000),
 * 百万位(1e6)和十亿(1e9)来组合了（这里传入的参数是int，最大也就到十亿位
 */
public class k273 {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        Integer[] t = new Integer[test.size()];
        t =  test.toArray(t);
        System.out.println(1);
    }
    //这里为了便捷查询，使用空位填充
    String[] low = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] mid = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] high = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public String numberToWords(int num) {
        StringBuilder ans = new StringBuilder();
        if(num == 0)
            return "";
        //判断十亿位
        if(num >= 1e9){
            int tmp = (int)(num / 1e9);
            //注意空格的添加
            ans.append(low[tmp]).append(" ").append("Billion ");
            num %= 1e9;
        }
        //判断百万位
        if(num >= 1e6){
            int tmp = (int)(num / 1e6);
            ans.append(numStringBuild(tmp)).append("Million ");
            num %= 1e6;
        }

        if(num >= 1000){
            int tmp = (int)(num / 1000);
            ans.append(numStringBuild(tmp)).append("Thousand ");
            num %= 1000;
        }

        if(num != 0)
            ans.append(numStringBuild(num));

        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }

    //构建百位-个位字符串
    public String numStringBuild(int num){
        StringBuilder res = new StringBuilder();

        if(num >= 100) {
            res.append(low[num / 100]).append(" ").append("Hundred ");
            num %= 10;
        }

        if(num >= 10){
            if(num / 10 > 1) {
                res.append(high[num / 10]).append(" ");
                num %= 10;
            } else {
                res.append(mid[num % 10]).append(" ");
                num = 0;
            }
        }

        if(num > 0)
            res.append(low[num]).append(" ");

        return res.toString();
    }

}
