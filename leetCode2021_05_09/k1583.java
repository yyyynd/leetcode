package leetCode2021_05_09;

/**
 * 开始的思路是想取每一对中的每个数字都与其他配对中的数字比较来确定是否为不开心元素
 *
 * 第二种思路就是，因为判断为不开心数的条件是p[x,u] > p[x,y] 且p[u,x] > p[u,v]s
 * 所以理论上只要比所有亲密度大于p[x,y]的点就行了，也就是x对这个u点的亲密度一定要大于x对y的才能继续判断
 *
 * 因此先对亲密度进行了整理得出一个每个点与其余点的亲密度矩阵，然后根据这个矩阵查找
 * 其配对点在其preferences亲密度顺序排列数组中所处的位置，遍历所有这个位置之前的元素
 * 判断是否能组成符合条件的配对，是当前元素成为不开心元素
 *
 * 顺便这里配中的顺序在重新匹配时是很重要的，因为如果是用yu配对，则为
 * p[y,u] > p[y,x] 且p[u,y] > p[u,v]才行，顺序是发生改变的，因此这里多增设一个存储每个点其匹配点的数组
 * 不但方便查找同时也因为其相当于存储了一个相反的顺序，所以能够直接套在一个循环中使用
 *
 * 这题最大的误导就是有n/2个匹配，但实际上在判断时，其它n/2-1个配对都可以看做一个个单独的点也就是n-2个点
 * 它们都可以与当前点匹配，所以这样想的话，我们就更能理解为什么能想到只判断部分亲密度更高的点了
 *
 * 也可以说这道题实际上和paris没什么大关系，这个配对也只是排除一个点，本质还是一个点和其它剩余点组合来进行判断的问题
 */
public class k1583 {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] order = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                order[i][preferences[i][j]] = j;
            }
        }
        int[] match = new int[n];
        for (int[] pair : pairs) {
            int person0 = pair[0], person1 = pair[1];
            match[person0] = person1;
            match[person1] = person0;
        }
        int unhappyCount = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = order[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]) {
                    unhappyCount++;
                    break;
                }
            }
        }
        return unhappyCount;
    }



}
