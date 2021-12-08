package leetCode2021_05_09;

import java.util.*;

public class k692 {
    public List<String> topKFrequent(String[] words, int k) {
        //专门存单词
        HashSet<String> wordSet = new HashSet<>();
        HashMap<String,Integer> wordCount = new HashMap<>();
        for(String word : words){
            if(wordSet.add(word)){
                //自动包装为Integer
                wordCount.put(word,1);
            }else{
                wordCount.put(word,wordCount.get(word)+1);
            }
        }

        Iterator<Map.Entry<String,Integer>> iterator = wordCount.entrySet().iterator();
        ArrayList<Map.Entry<String,Integer>> wordList = new ArrayList<>();
        while (iterator.hasNext()){
            wordList.add(iterator.next());
        }

        //根据出现次数排序
        wordList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> stringIntegerEntry, Map.Entry<String, Integer> t1) {

                int compare = stringIntegerEntry.getValue().compareTo(t1.getValue());

                if(compare == 0 && stringIntegerEntry.getKey().compareTo(t1.getKey()) < 0 )
                    return -1;
                else if(compare == 0 && stringIntegerEntry.getKey().compareTo(t1.getKey()) > 0 )
                    return 1;
                else
                    return -compare;
//                return -stringIntegerEntry.getValue().compareTo(t1.getValue());
            }
        });

        List<String> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(wordList.get(i).getKey());
        }

        return result;
    }
}
