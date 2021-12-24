package leetCode2021_12;

import java.util.*;

/**
 * 每次优先吃快要坏掉的苹果才能保证吃掉最多的苹果
 *
 * 记录当前天数，通过一个队列存储苹果信息，存储信息格式为[苹果数量，保质天数+当前天数=过期日期]
 * 然后每次插入新信息的时候，已存在队列中的信息通过过期日期-当前天数得出剩余保质期天数，然后比较当前插入
 * 苹果的存储信息，得出插入位置
 */
public class k1705 {

    public static void main(String[] args) {
        System.out.println(new k1705().eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}));
    }
    class Inform {
        int num;
        int date;
        public Inform() {
        }

        public Inform(int num, int date) {
            this.num = num;
            this.date = date;
        }
    }

    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        int curDate = 1;
        Queue<Inform> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t.date));

        for (int i = 0; i < apples.length; i++){
            while (!queue.isEmpty() && queue.peek().date < curDate)
                queue.poll();
            if(apples[i] != 0)
                queue.add(new Inform(apples[i], days[i] + curDate - 1));

            Inform cur = queue.peek();
            if(cur != null){
                ans++;
                cur.num--;
                if(cur.num == 0)
                    queue.poll();
            }
            curDate++;
        }

        while (!queue.isEmpty()){
            while (!queue.isEmpty() && queue.peek().date < curDate)
                queue.poll();
            Inform cur = queue.poll();
            if(cur == null)
                break;
            int maxEatNum = Math.min(cur.num, cur.date - curDate + 1);
            ans += maxEatNum;
            curDate += maxEatNum;
        }

        return ans;
    }
}
