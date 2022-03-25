package leetcode.leetCode2022_03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class k950 {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; i--){
            int tmp = list.pollLast();
            list.addFirst(tmp);
            list.addFirst(deck[i]);
        }
        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()){
            int n = iterator.next();
            deck[i] = n;
            i++;
        }

        return deck;
    }
}
