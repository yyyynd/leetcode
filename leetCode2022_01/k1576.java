package leetCode2022_01;

/**
 * 还要考虑一下出现连续问号的情况
 */
public class k1576 {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        if(len == 1)
            return arr[0] == '?' ? String.valueOf('a') : s;
        if(arr[0] == '?') {
            if (arr[1] == '?')
                arr[0] = 'a';
            else
                arr[0] = (char) ((arr[1] + 1) % 26 + 'a');
        }

        for (int i = 1; i < len-1; i++){
            if(arr[i] == '?'){
                arr[i] = (char) ((arr[i-1] + 1) % 26 + 'a');
                if(arr[i] == arr[i+1])
                    arr[i] = (char) ((arr[i+1] + 1) % 26 + 'a');
            }
        }
        if(arr[len-1] == '?')
            arr[len-1] = (char) ((arr[len-2] + 1) % 26 + 'a');
        return String.valueOf(arr);
    }
}
