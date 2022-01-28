//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
// 如果有多对数字的和等于s，则输出任意一对即可。

import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2022/1/28 13:51
 */
public class TwoSum {
    public int[] twoSum(int[] nums,int target){
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(target-nums[i])){
                return new int[]{nums[i],target-nums[i]};
            }else {
                set.add(nums[i]);
            }
        }
        return new int[]{};
    }

    /**
     * 对撞双指针
     * 初始化：双指针i,j分别指向数组nums的左右两端
     * 计算和s=nums[i]+nums[j]
     * 若s>target，j--;
     * 若s<target,i++;
     * 若s=target，返回[nums[i],nums[j]]
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums,int target){
        int i=0,j=nums.length-1;
        while(i<j){
            int s=nums[i]+nums[j];
            if(s<target) i++;
            else if(s>target) j--;
            else return new int[]{nums[i],nums[j]};
        }
        return new int[0];
    }
}
