package leetCode2021_10;

import java.util.ArrayList;
import java.util.List;

public class k412 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        String[] strings = new String[]{"","Fizz","Buzz","FizzBuzz"};
        int flag = 0;
        for(int i = 1; i <= n; i++){
            flag += i % 3 == 0 ? 1 : 0;
            flag += i % 5 == 0 ? 2 : 0;
            if(flag != 0)
                ans.add(strings[flag]);
            else
                ans.add(String.valueOf(i));
            flag = 0;
        }
        return ans;
    }
}
