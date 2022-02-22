package leetcode.leetCode2022_02;

import java.util.*;

public class k341 {
    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        Deque<NestedInteger> deque = new LinkedList<>();
        public NestedIterator(List<NestedInteger> nestedList) {
            deque.addAll(nestedList);
        }

        @Override
        public Integer next() {
            return deque.removeFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            if(deque.isEmpty())
                return false;

            NestedInteger curNested = deque.getFirst();
            if(!curNested.isInteger()){
                deque.removeFirst();
                List<NestedInteger> list = curNested.getList();
                for (int i = list.size() - 1; i >= 0; i--)
                    deque.addFirst(list.get(i));
                return hasNext();
            }

            return true;
        }
    }

}
