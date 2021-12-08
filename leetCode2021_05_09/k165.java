package leetCode2021_05_09;

public class k165 {

    public static void main(String[] args) {
        System.out.println(new k165().compareVersion("1","1.1"));
    }
    public int compareVersion(String version1, String version2) {
        int length1 = version1.length();
        int length2 = version2.length();
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int i,j;
        for (i = 0,j = 0; i < length1 || j < length2;){
            int curV1 = 0;
            int curV2 = 0;
            while (i < length1) {
                if(v1[i] != '.') {
                    curV1 += curV1 * 10 + v1[i] - '0';
                    i++;
                }else {
                    i++;
                    break;
                }
            }
            while (j < length2 ) {
                if(v2[j] != '.') {
                    curV2 += curV2 * 10 + v2[j] - '0';
                    j++;
                } else{
                    j++;
                    break;
                }
            }
            if(curV1 < curV2)
                return -1;
            else if(curV1 > curV2)
                return 1;
        }

        return 0;

//        if(i == length1 && j == length2)
//            return 0;
//        else if(i < length1) {
//            int curV1 = 0;
//            while (i < length1){
//                if(v1[i] != '.')
//                    curV1 += curV1 * 10 + v1[i] - '0';
//                if(curV1 != 0)
//                    return 1;
//                i++;
//            }
//            return 0;
//        } else {
//            int curV2 = 0;
//            while (j < length2){
//                if(v2[j] != '.')
//                    curV2 += curV2 * 10 + v2[j] - '0';
//                if(curV2 != 0)
//                    return -1;
//                j++;
//            }
//            return 0;
//        }
    }
}
