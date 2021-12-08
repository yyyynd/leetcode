package leetCode2021_05_09;

public class k541 {

    public static void main(String[] args) {
        System.out.println(new k541().reverseStr("a",8));
    }

    public String reverseStr(String s, int k) {
        int left = 0;
        int right = 2*k-1;
        char[] str = s.toCharArray();
        while (right < str.length){
            for (int i = 0; i < k/2; i++){
                    char tmp = str[left+i];
                    str[left+i] = str[left+k-i-1];
                    str[left+k-i-1] = tmp;
                }
            left = right+1;
            right = right+2*k;
        }

        int remain = Math.min(str.length-left , k);
        for (int i = 0; i < remain/2; i++){
            char tmp = str[left+i];
            str[left+i] = str[left+remain-i-1];
            str[left+remain-i-1] = tmp;
        }

        return String.valueOf(str);
    }

//    public void reverse(char[] str, int left, int right)
}
