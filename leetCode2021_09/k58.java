package leetCode2021_09;

public class k58 {

    public int lengthOfLastWord(String s) {
        int ans = 0;
        int tmp = 0;
        char[] str = s.toCharArray();
        for(int c : str){
            if(c == ' ') {
                if(tmp != 0){
                    ans = tmp;
                    tmp = 0;
                }
            }
            else
                tmp++;
        }
        //防止最后一个单词之后没有出现空格刷新答案
        if(tmp != 0)
            ans = tmp;

        return ans;
    }
}
