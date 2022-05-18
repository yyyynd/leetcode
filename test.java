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
        String p = "0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t1\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t1\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0";
        String[] ps = p.split("\\s+");
//        System.out.println(Arrays.toString(ps));
        int[] path = new int[ps.length];
        for (int i = 0; i < path.length; i++)
            path[i] = Integer.parseInt(ps[i]);
        int[] set = new int[198 + 1];
//        for (int n : path){
//            if (set[n] != 0){
//                System.out.println(n);
//                System.out.println("error");
//                break;
//            }else
//                set[n] = 1;
//        }
        for (int i = 0; i < 198; i++){
            if(path[i] != 0)
                set[i + 1] = 1;
        }

        for (int i = 1; i < 199; i++){
            if (set[i] == 1)
                System.out.println(i);
        }


//        double res = 0;
//        for (int i = 0; i < n - 1; i++)
//            res += distance[path[i]][path[i+1]];
//        res += distance[path[0]][path[n - 1]];
//
//        System.out.println(res);

    }
}
