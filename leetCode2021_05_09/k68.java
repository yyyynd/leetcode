package leetCode2021_05_09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class k68 {
    public static void main(String[] args) {
        String[] str = {"What","must","be","acknowledgment","shall","be"};
        System.out.println(new k68().fullJustify(str,16));
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<>();
        int curLength = 0;//计算当前字符串已经组的长度
        int l = 0;//标记范围的左标记
        int r = 0;//标记范围的右标记
        for(; r < words.length; r++){
            curLength += words[r].length();
            if(curLength < maxWidth )
                curLength++;//假设之后还能加单词，先算入一个空格占一位
            else if(curLength == maxWidth){
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = l; j < r; j++)
                    stringBuilder.append(words[j]).append(" ");
                stringBuilder.append(words[r]);
                ans.add(stringBuilder.toString());

                l = r+1;
                curLength = 0;
            }else {
                StringBuilder stringBuilder = new StringBuilder();
                int voidCount = r-l-1;
                //记得减去未考虑的单词长度和之前计算字符串长度时暂时考虑的一个空位,计算纯单词长度
                int voidLength = maxWidth - ( curLength - words[r].length() - (r - l));
                char[] voidStr = voidCount == 0 ? new char[voidLength] : new char[voidLength/voidCount];
                Arrays.fill(voidStr,' ');
                //这里新考虑的单词不加入，所以r退后一位
                r--;
                if(voidCount == 0)
                    stringBuilder.append(words[l]).append(voidStr);
                else {
                    int voidStrAvg = voidLength % voidCount;
                    //如果无法平均分配空格
                    if (voidStrAvg != 0) {
                        for (int j = 0; j < voidStrAvg; j++)
                            stringBuilder.append(words[l + j]).append(voidStr).append(" ");
                    }
                    for (int j = l + voidStrAvg; j < r; j++)
                        stringBuilder.append(words[j]).append(voidStr);
                    stringBuilder.append(words[r]);
                }
                ans.add(stringBuilder.toString());

                l = r+1;
                curLength = 0;
            }
        }//for
        //判断循环终止时是否还有未处理的单词
        if(curLength != 0){
            StringBuilder stringBuilder = new StringBuilder();
            int voidLength = maxWidth - curLength;
            char[] voidStr = new char[voidLength];
            Arrays.fill(voidStr,' ');
            for (int j = l; j <= r-1; j++)
                stringBuilder.append(words[j]).append(" ");
            stringBuilder.append(voidStr);
            ans.add(stringBuilder.toString());
        }

        return ans;
    }
}
