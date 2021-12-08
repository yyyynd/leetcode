package leetCode2021_05_09;

import java.util.ArrayList;

public class k474 {
    public static void main(String[] args) {
        String[] str = {"10", "0001", "111001", "1", "0"};
        System.out.println(new k474().findMaxForm(str,5,3));
    }

    class SubStr{
        //数字1的个数
        int oneCount = 0;
        //数字0的个数
        int zeroCount = 0;
        //字符串长度
        int length = 0;

        public SubStr() {
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int subStrNum = strs.length;
        int[][][] dp = new int[subStrNum+1][m+1][n+1];
        ArrayList<SubStr> arr = new ArrayList<>();

        for(String subStr : strs){
            int i = 0;
            SubStr newSubStr = new SubStr();
            for (i = 0; i < subStr.length();i++){
                char currentChar = subStr.charAt(i);
                if(currentChar == '0')
                    newSubStr.zeroCount++;
                else
                    newSubStr.oneCount++;
            }
            newSubStr.length = i;
            arr.add(newSubStr);
        }

        return 0;
//        arr.sort(Comparator.comparingInt((SubStr subStr) -> subStr.length));
//        //已经累计的1个数，j统计0的个数
//        int i = 0,j = 0;
//        int result = 0;
//
//        //n是1的个数，m是0的个数
//        for (SubStr s : arr) {
//            if(i+s.oneCount <= n && j+s.zeroCount <=m) {
//                i += s.oneCount;
//                j += s.zeroCount;
//                result++;
//                continue;
//            }
//            //已经达到上限了，无需继续遍历
//            if(i+j == m+n)
//                break;
//            //因为是按长度升序排列，如果剩余的空间已经小于子串长度了，则必不可能再有符合的了
//            if(m+n-i-j < s.length)
//                break;
//        }
//        return result;
    }
}
