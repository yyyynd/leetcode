package leetCode2021_10;

public class k434 {
    public static void main(String[] args) {
        System.out.println(new k434().countSegments(", , , ,        a, eaefa"));
    }
    public int countSegments(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        int ans = 0;
        for(char c : str){
            if(c != ' ')
                count++;
            else if( count != 0){
                ans++;
                count = 0;
            }
        }
        if(count != 0)
            ans++;

        return ans;
    }
}
