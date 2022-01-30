//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author wy
 * @date 2022/1/29 16:22
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums,int k){
        if(k==0){
            return new int[]{};
        }
        ArrayList<Integer> res=new ArrayList<Integer>();
       int max=Integer.MIN_VALUE;
       for(int i=0;i<k;i++){
           max=Math.max(max,nums[i]);
       }
       int l=0,r=k;
       res.add(max);
       while(r<nums.length){
           if(nums[r]>max){
               max=nums[r];
               r++;
               l++;
           }else {
               l++;
               max=nums[l];
               for(int i=l;i<=r;i++){
                   max= Math.max(max,nums[i]);
               }
               r++;
           }
           res.add(max);
       }
       return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] maxSlidingWindow1(int[] nums,int k){
        int n=nums.length;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1];
            }
        });
        for(int i=0;i<k;i++){
            pq.offer(new int[]{nums[i],i});
        }
        int[] ans=new int[n-k+1];
        ans[0]=pq.peek()[0];
        for (int i=k;i<n;i++){
            pq.offer(new int[]{nums[i],i});
            while(pq.peek()[1]<=i-k){
                pq.poll();
            }
            ans[i-k+1]=pq.peek()[0];
        }
        return ans;
    }
}
