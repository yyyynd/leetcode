package leetCode2021_10;

import java.util.Iterator;

public class k284 implements Iterator<Integer>{
    Iterator<Integer> iterator;
    Integer next;

    public k284(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.next = iterator.next();
        // initialize any member here.
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return next == null;
    }
}
