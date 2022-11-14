package leetcode.leetCode2022_11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class k690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (Employee e : employees)
            map.put(e.id, e);

        int ans = 0;
        LinkedList<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        set.add(id);
        while (!queue.isEmpty()){
            Employee e = queue.pollFirst();
            ans += e.importance;
            for (int i : e.subordinates){
                if (!set.contains(i))
                    queue.add(map.get(i));
            }
        }

        return ans;
    }
}
