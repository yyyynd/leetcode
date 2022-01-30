package leetcode.leetCode2022_01;

import java.util.*;

public class k884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> ans = new LinkedList<>();
        String[] arr = s1.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr)
            map.put(s, map.getOrDefault(s, 0) + 1);
        arr = s2.split(" ");
        for (String s : arr)
            map.put(s, map.getOrDefault(s, 0) + 1);
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if(map.get(key) == 1)
                ans.add(key);
        }

        return ans.toArray(new String[0]);
    }
}
