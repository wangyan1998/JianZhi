//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//        输出结果可能非常大，所以你需要返回一个字符串而不是整数
//        拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0

import java.util.Arrays;

/**
 * @author wy
 * @date 2022/1/28 14:18
 */
public class MinNumber {
    /**
     * 此题其实本质还是排序问题，设数组nums中任意两数字的字符串为x,y，规定排序判断顺序为：
     * 若字符串拼接x+y>y+x，则x"大于"y
     * 若x+y<y+x，则x"小于"y
     * 使用这种排序规则进行排序，然后连接起来就是最小的。
     * @param nums
     * @return
     */
    public String minNumber(int[] nums){
        String[] strs=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i]=String.valueOf(nums[i]);
        }
        quickSort(strs,0,strs.length-1);
        StringBuilder res=new StringBuilder();
        for (String s:strs){
            res.append(s);
        }
        return res.toString();
    }
    public void quickSort(String[] strs,int l,int r){
        if(l>=r) return;
        int i=l,j=r;
        String tmp=strs[i];
        while(i<j){
            while((strs[j]+strs[l]).compareTo(strs[l]+strs[j])>=0&&i<j) j--;
            while((strs[i]+strs[l]).compareTo(strs[l]+strs[i])<=0&&i<j) i++;
            tmp=strs[i];
            strs[i]=strs[j];
            strs[j]=tmp;
        }
        strs[i]=strs[l];
        strs[l]=tmp;
        quickSort(strs,l,i-1);
        quickSort(strs,i+1,r);
    }

    /**
     * 使用内置函数完成排序
     * @param nums
     * @return
     */
    public String minNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
