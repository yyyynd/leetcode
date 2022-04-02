package leetcode.leetCode2022_04;

public class k151 {
    public static void main(String[] args) {
        System.out.println(new k151().reverseWords("a good   example"));
    }
    public String reverseWords(String s) {
//        String[] slist = s.split("[^\\w]");
//        StringBuilder res = new StringBuilder();
//        for (int i = slist.length - 1; i >= 0; i--){
//            if (!slist[i].isEmpty())
//                res.append(slist[i]).append(" ");
//        }
//        res.deleteCharAt(res.length() - 1);
//        return res.toString();
        char[] str = s.toCharArray();
        int len = 0;
        int travel = 0;
        int cur = 0;
        boolean flag = true;

        while (travel < str.length){
            if(str[travel] != ' '){
                str[cur] = str[travel];
                cur++;
                flag = false;
            }else if(!flag){
                str[cur] = ' ';
                cur++;
                flag = true;
            }
            travel++;
        }

        len = flag ? cur - 1 : cur;
        convert(0, len - 1,str);
        int start = 0;
        int end = 0;
        while (end < len){
            if(str[end] == ' '){
                convert(start, end - 1, str);
                start = end + 1;
            }
            end++;
        }
        convert(start, end - 1, str);
        return new String(str, 0, len);
    }

    private void convert(int start, int end, char[] str){
        for (int i = 0; i < (end - start + 1)/2; i++){
            char tmp = str[start + i];
            str[start + i] = str[end - i];
            str[end - i] = tmp;
        }
    }
}
