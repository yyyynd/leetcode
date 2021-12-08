package leetCode2021_05_09;

import java.util.*;

/**
 * 这里用了很多的强转，其实是不利于代码的兼容性的（本来利用接口引用可以轻松替换实现）
 */
public class k1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {

        HashSet<String> itemSet = new HashSet<>();
        HashMap<String,HashMap<String,Integer>> record = new HashMap<>();

        for(List<String> order : orders){
            String table = order.get(1);
            String item = order.get(2);
            //更新菜单信息
            itemSet.add(item);
            //添加该桌信息
            if(!record.containsKey(table))
                record.put(table,new HashMap<>());
            //更新该桌订单信息
            HashMap<String,Integer> curTableOrders = record.get(table);
            curTableOrders.put(item, curTableOrders.getOrDefault(item,0)+1);
        }

        //整理菜单列表进行排序
        List<String> itemList = new LinkedList<>(itemSet);
        itemList.sort(Comparator.naturalOrder());

        List<List<String>> result = new LinkedList<>();

        for (Map.Entry<String, HashMap<String, Integer>> entry : record.entrySet()) {
            String table = entry.getKey();
            HashMap<String, Integer> order = entry.getValue();
            //该桌记录表
            List<String> tableRecord = new LinkedList<>();
            tableRecord.add(table);
            //按照菜单依次添加信息
            for(String i : itemList)
                tableRecord.add(String.valueOf(order.getOrDefault(i,0)));
            result.add(tableRecord);
        }

        result.sort(Comparator.comparingInt(strings -> Integer.parseInt(strings.get(0))));
        //添加菜单列表
        ((LinkedList)itemList).addFirst("Table");
        ((LinkedList)result).addFirst(itemList);

        return result;
    }
}
