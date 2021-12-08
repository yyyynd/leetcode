package leetCode2021_10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class k187 {
    public static void main(String[] args) {
        System.out.println(new k187().findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i + 10 <= s.length(); i++){
            String curStr = s.substring(i,i+10);
            int count =  map.getOrDefault(curStr,0);
            if(count == 1)
                ans.add(curStr);
            map.put(curStr,count+1);
        }

        return ans;
    }
}
