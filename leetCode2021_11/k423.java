package leetCode2021_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * z,w,u,v,x,g 只出在一个单词中出现，可以用于第一次定位 （ 0-5 ）
 */
public class k423 {

    public String originalDigits(String s) {
        char[] checkLetters = {'z','w','u','x','g','o','t','f','s','e'};
        int[] letterCounts = new int[26];
        int[] numCount = new int[10];
        //init letter map number
        HashMap<Character, Integer> letterMap = new HashMap<>();
        letterMap.put('z',0);
        letterMap.put('o',1);
        letterMap.put('w',2);
        letterMap.put('t',3);
        letterMap.put('u',4);
        letterMap.put('f',5);
        letterMap.put('x',6);
        letterMap.put('s',7);
        letterMap.put('g',8);
        letterMap.put('e',9);
        //init dictionary
        HashMap<Character, List<Character>> dictionary = new HashMap<>();
        dictionary.put('z', Arrays.asList('z','e','o','r'));
        dictionary.put('o', Arrays.asList('o','n','e'));
        dictionary.put('w', Arrays.asList('t','w','o'));
        dictionary.put('t', Arrays.asList('t','h','r','e','e'));
        dictionary.put('u', Arrays.asList('f','o','u','r'));
        dictionary.put('f', Arrays.asList('f','i','v','e'));
        dictionary.put('x', Arrays.asList('s','i','x'));
        dictionary.put('s', Arrays.asList('s','e','v','e','n'));
        dictionary.put('g', Arrays.asList('e','i','g','h','t'));
        dictionary.put('e', Arrays.asList('n','i','n','e'));

        //count pre letter's appearance times
        for (char c : s.toCharArray())
            letterCounts[c - 'a']++;

        for (int i = 0; i < 5; i++){
            List<Character> word = dictionary.get(checkLetters[i]);
            int count = letterCounts[checkLetters[i] - 'a'];
            numCount[letterMap.get(checkLetters[i])] += count;
            for (char c : word)
                letterCounts[c - 'a'] -= count;
        }

        for (int i = 5; i < 10; i++){
            List<Character> word = dictionary.get(checkLetters[i]);
            int count = letterCounts[checkLetters[i] - 'a'];
            numCount[letterMap.get(checkLetters[i])] += count;
            for (char c : word)
                letterCounts[c - 'a'] -= count;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++){
            while (numCount[i] != 0) {
                stringBuilder.append(i);
                numCount[i]--;
            }
        }

        return stringBuilder.toString();
    }
}
