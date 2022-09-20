import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 二面算法题：
 */
public class Interview2 {
    public static void main(String[] args) {
        System.out.println(method(27));
    }

    public static String method(int num){
        HashMap<Integer,Character> map=new HashMap<>();
        char c='A';
        for(int i=0;i<26;i++){
            map.put(i,(char)(c+i));
        }
        if(num<=26){
            return map.get(num-1).toString();
        }

        List<Integer> list=new ArrayList<>();
        while (num!=0){
            list.add(num%26);
            num/=26;
        }

        StringBuilder sb=new StringBuilder();
        for(int i:list){
            sb.append(map.get(i-1));
        }

        return sb.reverse().toString();





    }
}
