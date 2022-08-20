package leetcode.leetCode2022_08;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class k1656 {

    String[] arr;
    int ptr = 0;
    public k1656(int n) {
        this.arr = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        arr[idKey - 1] = value;
        List<String> list = new LinkedList<>();
        if (ptr == idKey - 1){
            for (int i = ptr; i < arr.length; i++){
                if (arr[i] == null) {
                    ptr = i;
                    break;
                }
                list.add(arr[i]);
            }
        }
        return list;
    }
}
