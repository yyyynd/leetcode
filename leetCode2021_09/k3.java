package leetCode2021_09;

import java.util.HashMap;
import java.util.HashSet;

public class k3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0)
            return 0;
        char[] str = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < str.length; i++){
            if(map.containsKey(str[i])){
                /**
                 * 这个Math.max的作用就是为了防止类似"tmmzuxt"这种的情况
                 * "mzuxt"是结果，但在遇到最后一个t的时候会发现map中已经存有t的位置信息了
                 * 如果直接以这个t为左端开始新计算子串是错误的
                 *
                 * 这个比较的目的就是为了防止在新计算的子串中加入的字符，在子串左端点的左侧出现
                 * 过（即这个字符在该子串中并不重复），只有字符的位置比left大才算在子串中重复出现了
                 * 才会重新开始计算子串
                 */
                left = Math.max(left,map.get(str[i]) + 1);
            }
            //
            map.put(str[i],i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
