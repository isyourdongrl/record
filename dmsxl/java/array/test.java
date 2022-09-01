package array;

import java.util.*;

public class test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int[][] arr=new int[m][3];
        for(int i=0;i<m;i++){
            arr[i][0]= scanner.nextInt();
            arr[i][1]= scanner.nextInt();
            arr[i][2]= scanner.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        int cur=-1;
        int res=0;
        for(int i=0;i<m;i++){
            if(cur==-1){
                cur=arr[i][0];
            }
            cur=Math.max(cur,arr[i][0]);
            int inr=Math.max(0,arr[i][2]-(cur-arr[i][0]));
            res+=inr;
            cur+=inr;
            if(i==0){
                res+=arr[i][0]-1;
            }else{
                res+=Math.max(0,arr[i][0]-Math.max(cur-arr[i-1][1],arr[i-1][1])-1);
            }
        }
        res+=Math.max(0,n-cur);
        System.out.println(res);
    }





}




