package leetcode.leetCode2022_02;

import java.util.*;

public class k49 {
    public static void main(String[] args) {
        System.out.println(new k49().groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"}));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            if(!map.containsKey(String.valueOf(c))){
                List<String> list = new LinkedList<>();
                list.add(s);
                map.put(String.valueOf(c), list);
            }else
                map.get(String.valueOf(c)).add(s);
        }

        return new LinkedList<>(map.values());
    }
}
