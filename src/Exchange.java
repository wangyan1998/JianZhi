//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
/**
 * @author wy
 * @date 2021/11/18 17:16
 */
public class Exchange {
    /**
     * 快排思想
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums){
        int n=nums.length-1;
        int i=0,j=n;
        while(i<j){
            while(i<j&&nums[j]%2==0){
                j--;
            }
            if(nums[j]%2==1){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[j]=temp;
            }
            while (i<j&&nums[i]%2==1){
                i++;
            }
            if(nums[i]%2==1){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        return nums;
    }
}
