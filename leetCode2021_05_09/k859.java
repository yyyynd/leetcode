package leetCode2021_05_09;

import java.util.HashSet;

public class k859 {

    /**
     *能符合条件的情况
     *  1.没有不相同的位，但存在两个位，它们元素相同的（比如s[m],s[n]均为
     *  2.s和goal只有两个位不同且 s[n] == goal[m],s[m] == goal[n]
     */
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length())
            return false;

        char[] sCharArr = s.toCharArray();
        char[] goalCharArr = goal.toCharArray();
        int[] point = new int[2];
        int count = 0;
        boolean sameChar = false;

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i <s.length(); i++){
            //判断是否为不同点
            if(sCharArr[i] != goalCharArr[i]) {
                //先判断一下是否不同点的数量已经超过限制了
                count++;
                if (count > 2)
                    return false;
                point[count-1] = i;
            }//if
            //如果还未发现两个位存在相同元素的情况，则存入字典
            //添加失败意味着之前已经存过该值，代表已有两个位的元素相同了
            if(!sameChar && !set.add(sCharArr[i]))
                sameChar = true;
        }
        //如果只有一个相异点，不符合
        if(count == 1)
            return false;
        //如果两个字符串完全相同，则看有无两个位是相同的元素
        if(count == 0)
            return sameChar;
        //最后判断只有两个相异点的时候，是否符合交换条件
        return sCharArr[point[0]] == goalCharArr[point[1]] &&
                sCharArr[point[1]] == goalCharArr[point[0]];
    }
}
