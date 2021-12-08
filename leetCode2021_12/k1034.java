package leetCode2021_12;

import java.util.LinkedList;

/**
 * 含有 [row][col]块的分“所有”连通分量都需要进行边界上色
 * 就是指如果大连通分量中的小连通分量也是需要进行一次边界上色的
 *
 * 采取dfs遍历每个新加入分量的块的四个方向寻找新的可加入块，如果没有就对当前块的四个方向进行着色
 * 注意要记忆化存储之前加入的位置，防止形成环路,再添加了所有的块之后，再依次针对分量边界进行着色(且需要为不在分量中的块)
 *
 * 这里边界块的定义就是连通分量中，其四周存在非连通分量的块，或者就是其位于边界上
 * （这里下面的是错误版本，虽然思路差不多是对的，就是利用dfs或者bfs找出整个连通分量
 */
public class k1034 {
    int rowLength;
    int colLength;
    int selectColor;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.rowLength = grid.length;
        this.colLength= grid[0].length;
        int[][] memory = new int[rowLength][colLength];
        this.selectColor = grid[row][col];
        LinkedList<int[]> list = new LinkedList<>();

        list.add(new int[]{row,col});
        memory[row][col] = 1;

        //查找出所有符合组成连通分量的块
        dfs(grid, list, memory, row, col);

        //对分量中所有快的领边进行着色
        for (int[] point : list){
            row = point[0];
            col = point[1];
            if(row == 0 || row == rowLength - 1|| col == 0 || col == colLength - 1) {
                grid[row][col] = color;
                continue;
            }

            if (row + 1 < rowLength - 1 && memory[row + 1][col] != 1)
                grid[row + 1][col] = color;
            if (row - 1 > 0 && memory[row - 1][col] != 1)
                grid[row - 1][col] = color;

            if (col + 1 < colLength - 1 && memory[row][col + 1] != 1)
                grid[row][col + 1] = color;
            if (col - 1 > 0 && memory[row][col - 1] != 1)
                grid[row][col - 1] = color;
        }

        return grid;
    }

    public void dfs(int[][] grid, LinkedList<int[]> list, int[][] memory, int row, int col){
        //判断四个方向是否还有可组成连通分量的块
        if(row - 1 >= 0 && grid[row - 1][col] == selectColor && memory[row - 1][col] == 0){
            memory[row - 1][col] = 1;
            list.add(new int[]{row - 1, col});
            dfs(grid, list, memory, row - 1, col);
        }

        if(row + 1 < rowLength && grid[row + 1][col] == selectColor && memory[row + 1][col] == 0){
            memory[row + 1][col] = 1;
            list.add(new int[]{row + 1, col});
            dfs(grid, list, memory, row + 1, col);
        }

        if(col - 1 >= 0 && grid[row][col - 1] == selectColor && memory[row][col - 1] == 0){
            memory[row][col - 1] = 1;
            list.add(new int[]{row, col - 1});
            dfs(grid, list, memory, row, col - 1);
        }

        if(col + 1 < colLength && grid[row][col + 1] == selectColor && memory[row][col + 1] == 0){
            memory[row][col + 1] = 1;
            list.add(new int[]{row, col + 1});
            dfs(grid, list, memory, row, col + 1);
        }
    }
}
