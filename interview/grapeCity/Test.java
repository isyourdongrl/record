/**
 * 葡萄城相关笔试题
 */
public class Test {

    /**
     * q：找出数组中连续子数组的最大和，lc剑指offer42，葡萄城二面
     * grade：easy
     * time：2022/9/17
     * @param arr
     * @return
     */
    public int maxSubArray(int[] arr){
        if(arr==null){
            return 0;
        }
        int sum=0;
        int i=0;
        while (i<arr.length){
            if(sum<0){
                sum=0;
            }else{
                sum+=arr[i];
            }
            i++;
        }
        return sum;
    }
}
