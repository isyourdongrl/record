package array;

public class array {


    /**
     * q:二分查找 lc704
     * grade：easy
     * time：2022/8/22 15:18
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }

        if(nums.length==1){
            return nums[0]==target?0:-1;
        }

        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target<nums[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }


    /**
     * q：原地移除指定元素 lc27
     * grade：easy
     * time：2022/8/22 15:19
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k++]=nums[i];
            }
        }
        return k;
    }


}
