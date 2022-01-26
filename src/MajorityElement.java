//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//        你可以假设数组是非空的，并且给定的数组总是存在多数元素。

import java.util.Arrays;

/**
 * @author wy
 * @date 2022/1/26 11:43
 */
public class MajorityElement {
    public int majorityElement(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
