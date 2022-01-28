//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2022/1/28 13:27
 */
public class SingleNumber {
    public int singleNumber(int[] nums){
        Map<Integer,Integer> res=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            res.put(nums[i],res.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:res.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumber1(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
