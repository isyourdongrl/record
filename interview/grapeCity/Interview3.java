import java.util.*;

public class Interview3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int max=Integer.MIN_VALUE;
        int max_fu=Integer.MIN_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            max=Math.max(max,arr[i]);
            if(arr[i]<0){
                map.put(i,-arr[i]);
                max_fu=Math.max(max_fu,-arr[i]);
            }
        }

//        for(int i:arr){
//            int blank=max-i;
//            for(int j=0;j<blank;j++){
//                System.out.println();
//            }
//            for(int z=0;z<i;z++){
//                System.out.println("#");
//            }
//        }


        List<String> list=new ArrayList<>();
        while (max>=0){
            StringBuilder sb=new StringBuilder();
            for(int i:arr){
                if(max>i){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            max--;
            list.add(sb.toString());
        }


        // 判断是否为负数
        if(!map.isEmpty()){
            for(int i=0;i<max_fu;i++){
                StringBuilder sb3=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(map.containsKey(j)){
                        if(map.get(j)>0){
                            sb3.append("#");
                            map.put(j,map.get(j)-1);
                        }else{
                            sb3.append(" ");
                        }
                    }else{
                        sb3.append(" ");
                    }
                }
                list.add(sb3.toString());
            }
        }

        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        char c='a';
        for(int i=0;i<n;i++){
            sb1.append("_");
            sb2.append((char)(c+i));
        }
        list.add(sb1.toString());
        list.add(sb2.toString());


        for(String s:list){
            System.out.println(s);
        }
    }
}
