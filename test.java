package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
//        FileReader file = new FileReader("C:\\files\\ACO_TSP\\data\\kroA100.tsp");
//        ArrayList<double[]> location = new ArrayList<>();
//        try (Scanner sc = new Scanner(file)) {
//            while (sc.hasNextLine()) {  //按行读取字符串
//                String line = sc.nextLine();
//                System.out.println(line);
//                if (line.equals("NODE_COORD_SECTION")){
//                    while (sc.hasNext()){
//                        String[] l = sc.nextLine().split(" ");
//                        if (l[0].equals("EOF"))
//                            break;
//                        int x = Integer.parseInt(l[1]);
//                        int y = Integer.parseInt(l[2]);
//                        location.add(new double[]{x,y});
//                    }
//                }
//            }
//        }
//
//        int n = location.size();
//        double[][] distance = new double[n][n];
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < n; j++){
//                distance[i][j] = Math.pow(Math.pow(location.get(i)[0] - location.get(j)[0], 2) +
//                        Math.pow(location.get(i)[1] - location.get(j)[1], 2) , 0.5);
//                distance[j][i] = distance[i][j];
//            }
//        }
        String p = "80    24    60    86     8    56    19    11    26    34 \n" +
                "   85    61    59    76    97    22    90    44    31    14 \n" +
                "   16    10    58    20    73    71     9    35    23    37 \n" +
                "   17    93    21    15    52    78    18    74    96    65 \n" +
                "   25    64     3    55    79    30    41    88     7    91 \n" +
                "   48     5    62    89    87    69     3    55     0    46 \n" +
                "   27    92    66    57    50    54    82    33    28    45 \n" +
                "   42    13    70    99    40     2    47    51    77    95 \n" +
                "    4    36    32    75    12    94    81    43    49    72 \n" +
                "   84    29    38    67     1    63    39    53    68    67 \n";
        String[] ps = p.split("\\s+");
        System.out.println(Arrays.toString(ps));
        int[] path = new int[ps.length];
        for (int i = 0; i < path.length; i++)
            path[i] = Integer.parseInt(ps[i]);
        int[] set = new int[ps.length + 1];
        for (int n : path){
            if (set[n] != 0){
                System.out.println(n);
                System.out.println("error");
                break;
            }else
                set[n] = 1;
        }
//        double res = 0;
//        for (int i = 0; i < n - 1; i++)
//            res += distance[path[i]][path[i+1]];
//        res += distance[path[0]][path[n - 1]];
//
//        System.out.println(res);

    }
}
