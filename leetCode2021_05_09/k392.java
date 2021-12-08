package leetCode2021_05_09;

public class k392 {

    public static void main(String[] args) {
        System.out.println(new k392().isSubsequence(
                "abc",
                "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        char[] s_ar = s.toCharArray();
        char[] t_ar = t.toCharArray();

        int i = 0;
        int j = 0;
        while (i < s_ar.length){
            if(j == t_ar.length)
                return false;
            if(s_ar[i] == t_ar[j])
                i++;
            j++;
        }

        return true;
    }
}
