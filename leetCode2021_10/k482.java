package leetCode2021_10;

public class k482 {
    public static void main(String[] args) {
        char c = 'e';
        System.out.println((char) ('A' + (c - 'a')));
    }
    public String licenseKeyFormatting(String s, int k) {
        char[] str = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int count = 0;
        for ( char c : str){
            if( c != '-')
                count++;
        }

        if(count == 0)
            return "";

        int i = 0;
        if(count % k != 0) {
            for (int j = 0 ; i < str.length && j < count % k; i++) {
                if (str[i] == '-')
                    continue;
                int offset = str[i] - 'a';
                res.append(offset >= 0 ? (char) (offset + 'A') : str[i]);
                j++;
            }
            res.append('-');
        }
        count = 0;
        for (; i < str.length; i++){
            if( str[i] == '-' )
                continue;
            int offset = str[i] - 'a';
            res.append(offset >= 0 ? (char) ( 'A' + offset) : str[i]);
            count++;
            if(count == k){
                res.append('-');
                count = 0;
            }
        }
        //注意这里只是基本的代码单元，如果是中文or其它的字符这样删除会发生问题，因为这些字符由两个代码单元组成
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}
