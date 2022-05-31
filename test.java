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

        String p = "0 5 6 1 2 3 4 7 8 9 10 11 12 40 39 13 17 18 19 20 24 23 21 22 27 29 28 31 36 35 32 33 38 46 51 50 49 47 48 62 77 76 75 80 94 93 100 101 92 90 91 78 79 63 64 74 81 82 73 65 60 53 55 59 58 67 71 72 69 66 54 43 42 41 56 57 68 70 84 85 99 98 86 83 97 96 87 88 89 95 61 52 45 44 37 30 26 25 34 102 103 104 113 112 111 105 106 110 109 108 167 166 107 118 119 117 116 115 114 121 120 122 123 124 168 125 129 130 131 132 134 140 139 133 141 146 147 152 160 161 151 148 145 144 143 149 150 136 135 128 126 169 127 170 171 163 162 164 165 142 159 157 156 155 154 153 138 137 158 14 15 16 188 189 190 187 182 180 176 174 173 172 175 181 177 179 183 184 178 193 194 195 196 197 185 192 191 186 ";
        String[] ps = p.split("\\s+");
//        System.out.println(Arrays.toString(ps));
        int[] path = new int[ps.length];
        for (int i = 0; i < path.length; i++)
            path[i] = Integer.parseInt(ps[i]);
        Arrays.sort(path);
        int[] set = new int[200 + 1];
        for (int n : path){
            if (set[n] != 0){
                System.out.println(n);
                System.out.println("error");
                break;
            }else
                set[n] = 1;
        }
//        for (int i = 0; i < 198; i++){
//            if(path[i] != 0)
//                set[i + 1] = 1;
//        }
//
//        for (int i = 1; i < 199; i++){
//            if (set[i] == 1)
//                System.out.println(i);
//        }


//        double res = 0;
//        for (int i = 0; i < n - 1; i++)
//            res += distance[path[i]][path[i+1]];
//        res += distance[path[0]][path[n - 1]];
//
//        System.out.println(res);

    }
}
